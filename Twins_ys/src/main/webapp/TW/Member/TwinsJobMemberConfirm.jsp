<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=EUC-KR">
<title>Insert title here</title>
<script type="text/javascript">

	function pValue(){
		document.getElementById("userId").value = opener.document.userInfo.jmid.value;
	}
	
	function idCheck(){
		var jmid = document.getElementById("userId"). value;
		
		if (!jmid) {
			alert("���̵� �Է����� �ʾҽ��ϴ�.");
			return false;
		}
		else if((id< "0" || id > "9") && (id < "A" || id > "Z") && (id < "a" || id > "z")){
			alert("�ѱ� �� Ư�����ڴ� ���̵�� ����� �� �����ϴ�.");
			return false;
		}
	   else
            {
		   //alert("������")
                var param="jmid="+jmid
                httpRequest = getXMLHttpRequest();
                httpRequest.onreadystatechange = callback();
                httpRequest.open("POST", "/twins/jmConfirmIDController", true);    
                httpRequest.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded'); 
                httpRequest.send(param);
		}
	}
	function callback(){
		if(httpRequest.readyState == 4){
			
			var resultText = httpRequest.responseText;
			if(resultText == 0){
				alert("����Ҽ� ���� ���̵��Դϴ�.")
				document.checkForm.getElementById("cancelBtn").style.visibility = 'visible';
				document.checkForm.getElementById("useBtn").style.visibility='hidden';
				document.checkForm.getElementById("msg").innerHTML = "";
			}
			else if(resultText == 1){
				document.checkForm.getElementById("cancelBtn").style.visibility = 'visible';
				document.checkForm.getElementById("useBtn").style.visibility='hidden';
				document.checkForm.getElementById("msg").innerHTML = "��� ������ ���̵��Դϴ�.";
			}
		}
	}
	function sendCheckValue(){
		opener.document.userInfo.idDuplication.value = "idCheck";
		
		opener.document.userInfo.id.value = document.getElementById("userId").value;
		
		if (opener != null) {
			opener.chkForm = null;
			self.close();
		}
	}
</script>
</head>
<body onload="pValue()">
<div id ="wrap">
	<br>
	<b><font size="4" color = "read">���̵� �ߺ�üũ</font></b>
	<hr size = "1" width = "460">
	<br>
	<div id = "chk">
		<form id="checkForm">
		<input type="text" name="id" id="userId">
		<input type="button" value="�ߺ�Ȯ��" onclick="idCheck()">
		</form>
		<div id = "msg"></div>
		<br>
		<input id="cancelBtn" type="button" value="���" onclick="windwo.close()">
		<br>
		<input id = "useBtn" type="button" value="����ϱ�" onclick="sendCheckValue()"> 
	</div>
</div>
</body>
</html>