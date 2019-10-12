# androidstudio_project_HW1
**리눅스 우분투환경에서 개발하였습니다**
---
데이터베이스를 사용하지 않고 배열을 사용하여 유저관리하였습니다.
앱이 실행되고 있는 동안은 유저관리가 가능하지만 앱이 종료되면 데이터가 삭제됩니다.

1. 첫번째 페이지 : 로그인기능
 * 아이디와 비밀번호가 회원정보와 일치한다면 세번째 화면으로
 * 그렇지 않다면 오류메시지 출력
 * 해당 액티비티에서 회원정보를 담을 배열을 선언
 * 회원가입 버튼을 클릭시 배열을 두번째 액티비티로 넘긴다.
 * 두번째 액티비티에서 회원가입 버튼 클릭시 회원정보 배열을 다시 넘겨 받는다.
 * 추가된 정보를 가지고 회원가입이 되었는지 확인 후 세번째 액티비티로 전환
2. 두번째 페이지 : 회원가입
* 아이디, 비빌번호, 이름, 전화번호, 주소를 입력받아 각각 배열에 저장한다.
* 아이디 중복검사는 입력으로 들어온 아이디가 이미 존재하는지 확인
* 비밀번호 확인은 숫자만 입력으로 들어왔는지 확인
* 첫번째 액티비티로부터 넘겨받은 배열에 입력받은 회원정보를 추가한다
* 추가된 배열을 다시 첫번째 액티비티로 넘겨준다.
3. 세번재 페이지 : 계산기
* 간단한 사칙연산이 가능하다
