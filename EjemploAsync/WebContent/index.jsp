<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>

<div id="demo"></div>

<h1>The XMLHttpRequest Object</h1>

<button type="button"
onclick="loadDoc('ServletAJAX', myFunction)">Llama a AJAX
</button><br>
Lo que debe tardar el servicio en milisegundos: <input type="text" name="lo_que_tarda_ajax" value="100" id="retardo"/>


<script>
function loadDoc(url, cFunction) {
  var xhttp;
  xhttp=new XMLHttpRequest();
  xhttp.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
      cFunction(this);
    }
  };
  xhttp.open("GET", url + "?retardo=" + document.getElementById('retardo').value, true);
  xhttp.send();
}
function myFunction(xhttp) {
  document.getElementById("demo").innerHTML = xhttp.responseText;
}
</script>
</body>
</html>