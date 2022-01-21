<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<body>

<h1>The Window Object</h1>
<h2>The setTimeout() Method</h2>

<p>Wait 5 seconds for the greeting:</p>

<h2 id="demo1"></h2>
<h2 id="demo2"></h2>

<script>
const myTimeout = setTimeout(myGreeting, 5000);
var x = 0;
function myGreeting() {
  loadDoc('ServletAJAX', myFunction)
  document.getElementById("demo1").innerHTML = "Happy Birthday!" + x;
  x=x+1;
  setTimeout(myGreeting, 1000);
}
function loadDoc(url, cFunction) {
	  var xhttp;
	  xhttp=new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	      cFunction(this);
	    }
	  };
	  xhttp.open("GET", url + "?retardo=50", true);
	  xhttp.send();
	}
function myFunction(xhttp) {
	  document.getElementById("demo2").innerHTML = xhttp.responseText;
	}
</script>

</body>
</html>