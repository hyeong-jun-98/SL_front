var http = require("http");     // 내부모듈
var fs = require("fs");         // filesystem 모듈 (파일을 읽거나 쓰는 모듈  내부모듈)

// 서버구축

var server = http.createServer(function(request, response) {

    // 요청 처리코드
    console.log("클라이언트 요청 감지");

    // html 파일 읽기
    // fs.readFile("./index.html", "utf-8", function(error, data) {
    //     response.writeHead(200, {"Content-Type" : "text/html;charset=utf-8"}); // 헤더정보
    //     // response.end("나의 두번쨰 서버 응답정보");  //  바디 정보, 데이터 전달
    //     response.end(data);
    // });

    fs.readFile("./static/santa.png", function(error, data) {       // 이미지 처리
        response.writeHead(200, {"Content-Type" : "image/png"});
        response.end(data);
    })



    
});


// 서버 가동
server.listen(8989, function() {
// 가동되었울 때 코드
    console.log("서버 가동 준비 완료... 포트번호..8989");

});
