<%@ page language="java" contentType="text/html; charset=EUC-KR"
    pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="EUC-KR">
<title>��ǰ �߰�(�����ڿ�)</title>
</head>
<body>
<div align="center">
<h2>�߰��� ��ǰ������ �Է��ϼ���.</h2>
<form action="" method="post">
<table height="300" border="1">
	<tr>
		<th>��ǰ��</th>
		<td><input type="text" id="p_name"></td>
	</tr>
	<tr>
		<th>ȿ��</th>
		<td><input type="text" id="effect"></td>
	</tr>
	<tr>
		<th>�ǸŰ���</th>
		<td><input type="number" id="p_price"></td>
	</tr>
	<tr>
		<th>���� ī�װ�</th>
		<td>
			<input type="radio" name="category_1" value="1">���ι��̿�ƽ��
			<input type="radio" name="category_1" value="2">Į��/���׳׽�/��Ÿ��
			<input type="radio" name="category_1" value="3">��Ÿ��B<br />
			<input type="radio" name="category_1" value="4">��Ÿ��C
			<input type="radio" name="category_1" value="5">������
			<input type="radio" name="category_1" value="6">��ũ����
			<input type="radio" name="category_1" value="7">���ް�3
		</td>
	</tr>
	<tr>
		<th>���� ī�װ�</th>
		<td>
			<input type="radio" name="category_2" value="1">���γ���
			<input type="radio" name="category_2" value="2">���
			<input type="radio" name="category_2" value="3">û�ҳ�
			<input type="radio" name="category_2" value="4">�ӻ��
			<input type="radio" name="category_2" value="5">�ôϾ�
		</td>
	</tr>
</table>
<br />
<input type="submit" value="��ǰ �߰�">
<input type="reset" value="�ʱ�ȭ">
</form>
</div>
</body>
</html>