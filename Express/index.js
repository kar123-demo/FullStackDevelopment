const express=require('express')
const app=express()
let json=require("./data.json")
const fs=require('fs')
// app.get('/',(req,res)=>{
//     res.status(200).json({name:"karthik",age:21})
// })
app.use(express.urlencoded({extended:true}))
app.use(express.json())
function updatefile(){
  fs.writeFile("./data.json",JSON.stringify(json, null, 2),(err) => {
            if (err) {
                return res.status(500).send("Error saving data");
            }
            res.send("Data added successfully");
        }
    );
}
app.get("/api/users/:id",(req,res)=>{
  let user=json.find((i)=>i.id===Number(req.params.id))
    // let user=null
    // for(let i of json){
    //     if(i.id==Number(req.params.id)){
    //         user=i;break;
    //     }
    // }
    res.json(user)
})
app.post("/api/users/add", (req, res) => {
    const user = {
        id: json.length + 1,
        ...req.body
    };
  console.log(user)
    json.push(user);
updatefile();
  
});
app.patch("/api/users/:id", (req, res) => {
    let user=json.find((i)=>i.id===Number(req.params.id))
    user.name=req.body.name
    user.email=req.body.email
console.log(user)
updatefile()
res.send("Updated")

});
app.delete("/api/users/:id", (req, res) => {
       let user=json.find((i)=>i.id===Number(req.params.id))
       json=json.filter((u)=>u.id!=req.params.id)
       updatefile()
       res.send("Deleted")
})
app.get("/api/users",(req,res)=>{

    res.status(200).sendFile(__dirname+"/data.json")
})
app.listen(3000,()=>{
    console.log("Server started")
})
