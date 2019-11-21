<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>myorderForm</title>
</head>
<body>
	<div class="title-area">
		<h2 class="tit">주문/배송 조회</h2>
	</div>
	<HR>
	<ul class="step">
		<li><em>0</em> <span>주문접수</span></li>
		<li><em>0</em> <span>결제완료</span></li>
		<li><em>0</em> <span>상품준비중</span></li>
		<li><em>0</em> <span>배송중</span></li>
		<li><em>0</em> <span>배송완료</span></li>
	</ul>

<fieldset class="search-period">
		<legend></legend>
		<ul class="select-month">
			<li class="on"><button type="button" data-month="-1">1개월</button></li>
			<li ><button type="button" data-month="-3">3개월</button></li>
			<li ><button type="button" data-month="-6">6개월</button></li>
			<li ><button type="button" data-month="-12">12개월</button></li>
		</ul>
		<div class="select-range">
			<select id="cal-start-year" title="년도를 선택하세요" style="width:76px;">
				<option value="2017">2017</option>
				<option value="2018">2018</option>
				<option value="2019">2019</option>
			</select>
			<label for="cal-start-year">년</label>
			<select id="cal-start-month" title="달월을 선택하세요" style="width:60px;">
				<option value="01">1</option>
				<option value="02">2</option>
				<option value="03">3</option>
				<option value="04">4</option>
				<option value="05">5</option>
				<option value="06">6</option>
				<option value="07">7</option>
				<option value="08">8</option>
				<option value="09">9</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
			</select>
			<label for="cal-start-month">월</label>
			
			<span class="des">~</span>
			
			<select id="cal-end-year" title="년도를 선택하세요" style="width:76px;">
				<option value="2017">2017</option>
				<option value="2018">2018</option>
				<option value="2019">2019</option>
			</select>
			<label for="cal-end-year">년</label>
			<select id="cal-end-month" title="달월을 선택하세요" style="width:60px;">
				<option value="01">1</option>
				<option value="02">2</option>
				<option value="03">3</option>
				<option value="04">4</option>
				<option value="05">5</option>
				<option value="06">6</option>
				<option value="07">7</option>
				<option value="08">8</option>
				<option value="09">9</option>
				<option value="10">10</option>
				<option value="11">11</option>
				<option value="12">12</option>
			</select>
			<label for="cal-end-month">월</label>
		</div>
		<button type="button" class="btnLookup" id="do-search-period">조회</button>
	</fieldset>
	
	<script>
	START_DATE   = '';
	END_DATE     = '';

	$(document).ready(function(){
    	SearchPeriod.init();
	});
	</script>	

	<table class="orderlist">
		<caption>주문내역 목록</caption>
		<thead>
			<tr>
				<th>주문일자</th>
				<th>상품</th>
				<th>수량</th>
				<th>주문금액</th>
				<th>상태</th>
			</tr>
		</thead>

		<tbody class="history">
			<tr>
				<td colspan="5" class="nodata">기간 내 주문내역이 없습니다</td>
			</tr>
		</tbody>
	</table>
</body>
</html>