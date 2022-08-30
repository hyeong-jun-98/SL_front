var http = require("http");     // 모듈 가져오기
var fs =  require("fs");        // 파일을 제어할 수 있다. (읽거나 쓰기 가능)
var qs = require("querystring");        // 전송된 쿼리를 분석할 때 사용하는 모듈
var mysql = require("mysql");           // 외부모듈 npm을 이용하여 다운로드 한다.


// 서버 객체 생성
var server = http.createServer(function(request, response){
    // console.log("요청 받음");

    
        // 클라이언트의 요청을 구분할 줄 알아야 해당 요청마다 적절한 응답처리를 할 수 있다.
        console.log("url : " + request.url);

        switch(request.url) {
           
            case "/board/registform" :
                // 원칙적으로는 response.end() tag를 한줄씩 문자열로 전송해야 하지만 , 효율성이 떨어진다.
                // fs를 이용하여 파일의 내용을 모두 읽어 변수에 담아서 한꺼번에 출력시키자.
                fs.readFile("./board/regist.html", "utf-8", function(error, data) {
                    response.writeHead(200, {"Content-type" : "text/html;charset=utf-8"});      // 헤더정보 구성
                    response.end(data);     // 응답바디 구성
                });
                break;

                case "/board/regist" :
                    insert(request, response);
                    break;
        }
    });
// insert 글쓰기
function insert(request, response) {
    // 글쓰기 요청을 처리한다 (post 파라미터 받고 db에 insert)
    console.log("글 등록할 예정");
    // 파라미터 받기
    var postData = "";
    request.on("data", function(param) {
        // console.log("param is : "  + "" +param);
        postData = postData + param;  // 문자열 + Buffer = 문자열
    });   

    request.on("end", function(){
        console.log("최종 요청 데이터 : " + postData);
        var result = qs.parse(postData);     // 최종 데이터 파싱
        console.log(result.title, result.writer, result.content);

        //mysql 접속
        var con = mysql.createConnection({
            url:"localhost",
            user:"root",
            password:"1234",
            database:"javastudy"
        }); 
        var sql = "insert into board(title, writer, content) values (?,?,?)";
        con.query(sql, [result.title, result.writer, result.content],function(error, results, fields) {
            if(error) {
                response.writeHead(200, {"Content-type" : "text/html;charset=utf-8"});
                response.end("글쓰기 실패 (에러)");  // body
            } else {
                response.writeHead(200, {"Content-type" : "text/html;charset=utf-8"});
                response.end("글쓰기 성공");  // body
            }
        })
    });
   
}


// 서버 가동
server.listen(7979, function() {
    console.log("서버 가동 중...포트번호 7979");
});