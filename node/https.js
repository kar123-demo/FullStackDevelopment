const http=require('node:http')
const fs=require('fs')
const server=http.createServer((req,res)=>{
//   console.log(req.url)
if(req.url==='/'){
    res.writeHead(200,{'Content-Type':'text/plain'})
    res.write("Welcome to FSD")
    res.end()
}
else if(req.url==='/html'){
    const read=fs.createReadStream("demo.html","utf-8")
res.writeHead(200,{'Content-Type':'text/html'})
read.pipe(res)

}else if(req.url==='/json'){
    res.writeHead(200,{'Content-Type':'application/json'})
    res.end(JSON.stringify({name:"karthik",age:21}))
}else{
    res.writeHead(404,{'Content-Type':'text/plain'})
    res.end("Error")
}
})
server.listen(3200,()=>{
    console.log("Server Started")
})