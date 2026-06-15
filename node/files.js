// const fs=require("fs")
// console.log("Before Loading..")
// const data=fs.readFileSync("test.txt","utf-8")
// console.log(data)

// console.log("After Loading...")

// const fs=require("fs").promises

// async function read(){
// const data= await fs.readFile("test.txt","utf-8")
// console.log(data)
// console.log("Async execution")

// }
// async function main(){
//     console.log("Before Loading..")
// await read()
// console.log("After Loading...")
// }
// main()
// const fs=require("fs").promises
// async function append(){
//     try{
//          await   fs.appendFile("test.txt","\nFullStackDevelopments","utf-8");
//     let data= await fs.readFile("test.txt","utf-8")
// console.log(data);
//     }
//  catch(err){
//     console.log("Error")
//  }

// }
// append()
const fs=require('fs')
let read=fs.createReadStream("test.txt","utf-8")
let write=fs.createWriteStream("cpy.txt","utf-8")
// read.on("data",(data)=>{
// write.write(data)
// })
read.pipe(write)
