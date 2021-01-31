/**

 * 
 */
var inStock = {"cat": 10, "dog": 10, "fish": 10, "turtle": 10};
var items = '';
var originalAmount = 0;

$(document).ready(function(){
	
	$('.cat').click(function(){
		items = 'cat';
		populate();
	})
	$('.dog').click(function(){
		items = 'dog';
		populate();
	})
	$('.fish').click(function(){
		items = 'fish';
		populate();
	})
	$('.turtle').click(function(){
		items = 'turtle';
		populate();
	})
	
	$('#pay').click(function(){
		pay();
	})
	$('#cancel').click(function(){
		cancelSale();
	})
	
	
	$('#btnReciept').click(function(){
		lookupReceipt();
	})
	
	$('#btnSale').click(function(){
		newSale();
	})
	
	$('.zReading').click(function(){
		getZReading();
	})
	
	$('.xReading').click(function(){
		getXReading();
	})
	
	$('#refund').click(function(){
		refund();
	})
	
	$('#fullRefund').click(function(){
		fullRefund();
	})
	
	function buyItem() {
		$.ajax({
			url : "buy",
			method : 'GET',
			data : {
				items : items,
			},
			success : function(results) {
				if (results != null && results != "") {
					var amount = results.data;
					$('#totalAmount').val(amount);
				} else {
					//TODO display incorrect user
				}
			}
		})
	}
	
	function pay() {
		var paymentAmount = $('#inputCash').val();
		$.ajax({
			url : 'pay',
			method : 'GET',
			data : {
				amount : paymentAmount
			},
			success : function(results) {
				if (results != null && results != "") {
					var amount = results.data.total;
					var receiptID = results.data.uid;					
					$('#change').val(parseFloat(paymentAmount) - amount);
					$('#receiptId').val(receiptID);
				}
			}
		})
	}
	
	function increment(item) {
		if (inStock.hasOwnProperty(item)) {
	        inStock[item] = inStock[item] + 1;
		}
		//enable button
	}
	
	function decrement(item) {
	    if (inStock.hasOwnProperty(item)) {
	        inStock[item] = inStock[item] - 1;
		}
	    //disable button
	    if (inStock[item] <= 9) {
	    		//var buttonId = '.remove'+item;
	    		$('button').find('.cat').prop("disabled",true)
	    			.removeClass('btn-info')
	    			.addClass('btn-danger');
	    	
	    }
	}
	
	function cancelSale() {
		$.ajax({
			url : 'cancelSale',
			method : 'GET',
			success : function(results) {
				if (results != null && results != "") {
					$('#receiptText').val("");
					$('#receiptId').val("");
					$('#change').val("");
					$('#inputCash').val("");
					$('#totalAmount').val("");
					$('.items').empty();
				}
			}
		})
	}
	
	function lookupReceipt() {
		$('.items').empty();
		var receiptNumber = $('#receiptText').val();
		$.ajax({
			url : 'lookupReceipt',
			method : 'GET',
			data : {
				receiptNumber : receiptNumber
			},
			success : function(results) {
				if (results != null && results != "") {
					var amount = results.data.totalAmount;
					originalAmount = amount;
					var receiptID = results.data.uid;
					$('#totalAmount').val(amount);
					$('#receiptId').val(receiptID);
					loadReceiptItems(results.data.animals);
				}
			}
		})
	}
	
	function newSale() {
		$.ajax({
			url : 'newSale',
			method : 'GET',
			success : function(results) {
				if (results != null && results != "") {
					$('#receiptText').val("");
					$('#receiptId').val("");
					$('#change').val("");
					$('#inputCash').val("");
					$('#totalAmount').val("");
					$('.items').empty();
				}
			}
		})
	}
	
	function populate() {
		if (items == 'cat') {
			$('.items').append('<input type="button" onclick="removeCat()" class="btn btn-danger remove' + items + '" value="Remove ' + items + '" />');
		} else if (items == 'dog') {
			$('.items').append('<input type="button" onclick="removeDog()" class="btn btn-danger remove' + items + '" value="Remove ' + items + '" />');	
		} else if (items == 'turtle') {
			$('.items').append('<input type="button" onclick="removeTurtle()" class="btn btn-danger remove' + items + '" value="Remove ' + items + '" />');	
		} else if (items == 'fish') {
			$('.items').append('<input type="button" onclick="removeFish()" class="btn btn-danger remove' + items + '" value="Remove ' + items + '" />');	
		}
		//decrement(items);
		buyItem();
	}
	
	
})

function removeCat() {
	$(document.activeElement).remove();
	items = 'cat';
	removeItem();
}

function removeDog() {
	$(document.activeElement).remove();
	items = 'dog';
	removeItem();
}

function removeFish() {
	$(document.activeElement).remove();
	items = 'fish';
	removeItem();
}

function removeTurtle() {
	$(document.activeElement).remove();
	items = 'turtle';
	removeItem();
}

function removeItem() {
	$.ajax({
		url : 'remove',
		method : 'GET',
		data : {
			items : items,
		},
		success : function(results) {
			if (results != null && results != "") {
				var amount = results.data;
				$('#totalAmount').val(amount);
			} else {
				//TODO display incorrect user
			}
		}
	})
}

function loadReceiptItems(animals) {
	var total = 0;
	$.each(animals, function (index,value) {
		if (value.type == 'CAT') {
			$('.items').append('<input type="button" onclick="removeCat()" class="btn btn-danger remove' + value.type + '" value="Remove ' + value.type + '" />');
		} else if (value.type == 'DOG') {
			$('.items').append('<input type="button" onclick="removeDog()" class="btn btn-danger remove' + value.type + '" value="Remove ' + value.type + '" />');	
		} else if (value.type == 'FISH') {
			$('.items').append('<input type="button" onclick="removeTurtle()" class="btn btn-danger remove' + value.type + '" value="Remove ' + value.type + '" />');	
		} else if (value.type == 'TURTLE') {
			$('.items').append('<input type="button" onclick="removeFish()" class="btn btn-danger remove' + value.type + '" value="Remove ' + value.type + '" />');	
		}
	});
}

function getXReading() {
	$.ajax({
		url : 'xReading',
		method : 'GET',
		success : function(results) {
			if (results != null && results != "") {
				alert("X Reading: " + results.data);
			}
		}
	})
}

function getZReading() {
	$.ajax({
		url : 'zReading',
		method : 'GET',
		success : function(results) {
			if (results != null && results != "") {
				alert("Z Reading: " + results.data);
			}
		}
	})
}

function refund() {
	var amount = $('#totalAmount').val();
	var receiptNumber = $('#receiptText').val();
	$.ajax({
		url : 'refund',
		method : 'GET',
		data : {
			originalAmount : originalAmount,
			receiptNumber : receiptNumber
		},
		success : function(results) {
			if (results != null && results != "") {
				var amount = results.data;
				$('#change').val(amount);
				alert("Amount owed: " + amount);
			}
		}
	})
}

function fullRefund() {
	$.ajax({
		url : 'fullRefund',
		method : 'GET',
		data : {
			originalAmount : originalAmount
		},
		success : function(results) {
			if (results != null && results != "") {
				$('#change').val(originalAmount);
				$('#totalAmount').val("");
				alert("Full refunded amount: " + amount);
			}
		}
	})
}