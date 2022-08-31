var http = require("http");     // 내부모듈
let express = require ("express");  // 외부모듈
let mysql = require("mysql"); //sql
const { userInfo } = require("os");


let app = express();      // express 객체 생상

// express 모듈은 미들웨어라 불리는 함수를 지원, 기능 확장가능
app.use("/static",express.static("res"));           // res라는 디렉토리를 정적자원의 위치로 등록한다.  ->주소를 입력할 때 res는 안 붙여도 된다. res를 위치로 등록했기 때문에.
app.use(express.urlencoded({extended:true}));      // post 방식의 데이터를 받기위한 미들웨어 등록  -> json 방식
let con = mysql.createConnection({
    host:"localhost",
    user:"root",
    password:"1234",
    database:"javastudy"
})



// express 모듈을 이용할 경우 요청 처리도 express 모듈로 처리하면 된다.
app.get("/main", function(request, response) {      // 경로로 들어가면 요청이 감지  (localhost:8888/main)
    console.log("클라이언트 요청 감지..")
});

app.post("/board/regist", function(request, response) {

    console.log(request.body.title, request.body.writer);
    let sql = "insert into board (title, writer, content) values (?,?,?)";
    con.query(sql, [request.body.title, request.body.writer, request.body.content], function(error, fields) {
        if(error) {
            console.log("insert 실패", error);
        } else {
            console.log("insert 성공");
        }
    });

});

let server = http.createServer(app);

server.listen(8888, function() {
    console.log("서버 가동중....포트번호 8888...")
})