<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Kalkulator rat kredytu</title>
</head>
<body>
<center><H1><font color="teal">Kalkulator rat kredytu</font></H1></center>
	<form action="formularz" method="post">
		<label><center><H3><font color="red">Wnioskowana kwota kredytu: <input type="text" id="kwota" name="kwota" /></font></H3></center></label> 
		<label><center><H3><font color="red">Ilość rat: <input type="text" id="raty" name="raty" /></font></H3></center></label>  
		<label><center><H3><font color="red">Oprocentowanie: <input type="text" id="oprocentowanie" name="oprocentowanie" /></font></H3></center></label> 
		<label><center><H3><font color="red">Opłata stala: <input type="text" id="oplata" name="oplata" /></font></H3></center></label> 
		<label><center><H3><font color="red">Rodzaj rat: <select name="rodz_rat">
		<option value="stala">stała</option>
		<option value="malejaca">malejąca</option>
		
		 </select></font></H3></center></label>
		
		 <br/>
		<center><input type="submit" value="Wyślij" /></center>
	</form>
</body>
</html>