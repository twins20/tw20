<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
function checkValue(){
   
	if(document.userInfo.jmname.value ==""){
        alert("이름을 입력하세요.");
        return false;
    }
	else if(document.userInfo.jmid.value.length<5 ){
        alert("아이디는 5~20자 이상 입력해주십시오.");
       
    }
    
    else  if(document.userInfo.idDuplication.value = "idCheck"){
        alert("아이디 중복체크를 해주세요.");
     
    }
    
    else  if(document.userInfo.jmpsword.value.length<8){
        alert("비밀번호는 8~20자리 이상입니다.");
        
    }
    
    // 비밀번호와 비밀번호 확인에 입력된 값이 동일한지 확인
    else  if(document.userInfo.jmpsword.value != userInfo.jmpswordcheck.value ){
        alert("비밀번호를 동일하게 입력하세요.");
        return false;
    }    
}
	
	function inputIDChk(){
		document.userInfo.idDuplication.value = "idUncheck";	
	}
	
</script>
<style>
.test {

		  width        : 100px;     /* 너비는 변경될수 있습니다. */

		  white-space  : nowrap;    /* 줄바꿈을 하지 않습니다. */

		  overflow     : hidden;    /* 내용이 길면 감춤니다 */

		  display      : block;     /* ie6이상 현재요소를 블럭처리합니다. */

		}
	</style>
</head>

<body>
<form id = "userInfo" name="userInfo" action="${pageContext.request.contextPath }/twins/jmJoinActionController" onsubmit="return checkValue()">


<table>
<tr>
<td>
<input type="text" name="jmname"  >이름</td></tr>
<tr>
<td>
<input type="text" name="jmid" maxlength="20">아이디
<input type="button" value="중복확인" onclick="openIdChk()">
<input type="hidden" name="idDuplication"  value="idUncheck"></td></tr>
<tr>
<td>
<input type="password" name="jmpsword" maxlength="20">비밀번호</td></tr>
<tr>
<td>
<input type="text" name="jmaddr">주소</td></tr>
<tr>
<td>
<input type="text" name="jmemail">이메일</td></tr>
</table>
<input type="submit"  value="회원가입">
</form>

</body>
</html>