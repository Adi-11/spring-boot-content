# MongoDB trigger for having auti increment sequence


### trigger-code
#### This is needed to be added in mongoDB trigger 
* Ref URL: https://www.mongodb.com/resources/products/platform/mongodb-auto-increment
```
exports = async function (changeEvent) {
    const database = context.services.get("my-cluster").db(changeEvent.ns.db); // Replace with your database name
    const collection = database.collection(changeEvent.ns.coll); // Replace with your user collection name
    const sequenceCollection = database.collection("sequences"); // Collection to store sequences
    console.log(JSON.stringify(changeEvent))
    if (changeEvent.operationType === "insert") {
        try {
            // Get the next sequence value
            const sequenceDoc = await sequenceCollection.findOneAndUpdate(
                { _id: "userId" },
                { $inc: { sequence_value: 1 } },
                { upsert: true, returnNewDocument: true } // Ensure this is present
            );
            console.log(JSON.stringify(sequenceDoc));

            const nextUserId = sequenceDoc.sequence_value;


            // Update the inserted document with the generated ID
            await collection.updateOne(
                { _id: changeEvent.documentKey._id },
                { $set: { userId: nextUserId } }
            );

            console.log(`Assigned userId: ${nextUserId} to document: ${changeEvent.documentKey._id}`);

        } catch (error) {
            console.error("Error generating sequence ID:", error);
        }
    } else if (changeEvent.operationType === "invalidate"){
        console.log("Collection was invalidated, this is normal during first insert.");
    }
};
```

### sequences
```json
{
    "_id": "userId",
    "sequence_value": 0
}
```
