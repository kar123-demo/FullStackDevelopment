const event=require('events')
const newevent=new event.EventEmitter()
newevent.on("trigger",(name,age)=>{
console.log(`Name:${name},Age:${age}`)
})
newevent.emit("trigger","karthik",21)

const path=require('path')
console.log(__dirname)
console.log(__filename)
const fullPath = path.join('/root', 'karthik', 'file.txt');
console.log(fullPath);



const os=require('os')
console.log(`OS Platform: ${os.platform()}`);
console.log(`OS Type: ${os.type()}`);
console.log(`OS Release: ${os.release()}`);
console.log(`CPU Architecture: ${os.arch()}`);
console.log(`Hostname: ${os.hostname()}`);
const totalMemGB = (os.totalmem() )
const freeMemGB = (os.freemem())
console.log(`Memory: ${freeMemGB} free of ${totalMemGB}`);


