<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>第一順位の相続放棄</title>
</head>
<body>
  <h1>第一順位の相続放棄</h1>


  <h2>用意すべき書類等</h2>
　・亡くなった人の最後の住所地（この住所で手続きできる裁判所が確定します。）が載っている住民票
  <br>
　・亡くなった人の死亡の記載のある戸籍謄本（本籍地がある市町村役場で取得できます。）
  <br>
　・相続放棄したい人の戸籍謄本
 <br>
　・収入印紙８００円分（亡くなった人-相続放棄したい人の関係の数だけ）
 <br>
　・郵便切手（管轄裁判所により異なります。）

<br>
	<a href="checkAddress">管轄確認</a>
<form:form modelAttribute="first">
	申立人氏名<form:input path ="name"/>
	申立人住所<form:input path ="address"/>
	<input type="submit">
</form:form>

   <h2>${first.name}</h2>
         <h3>${first.address}</h3>

</body>
</html>