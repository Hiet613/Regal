<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>相続放棄</title>

<script>

function hyoji1(num)
{
  if (num == 0)
  {
    document.getElementById("disp").style.display="none";
  }
  else
  {
    document.getElementById("disp").style.display="block";
  }
}

</script>

</head>
<body>
<h1>亡くなった人とあなたの関係を選択してください。</h1>

<a href="first">第一順位★</a>（亡くなった人の配偶者（離婚している場合は除く）、子ども）
<br>
<a href="second">第二順位</a>（亡くなった人の尊属）
<br>
<a href="third">第三順位</a>（亡くなった人の兄弟、（兄弟が亡くなっている場合）甥姪）


<br>
<br>
相続放棄手続きとは？<form>
<input type="button" value="表示" onclick="hyoji1(1)">
<input type="button" value="非表示" onclick="hyoji1(0)">
</form>

<div id="disp" >「亡くなった人の財産について、プラスもマイナスも全ていりませんよ」と公的に述べる手続き。裁判所</div>






</body>
</html>