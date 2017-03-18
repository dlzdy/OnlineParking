  
//动态添加 表格序列号 在stuff/ stuff_list.jsp

   function sequenceTr(table_id){
        var len = $('#'+table_id+' tr').length;
        for(var i = 1;i<len;i++){
            $('#'+table_id+' tr:eq('+i+') td:first').text(i);
        }
   }
   
   

	 //给时间排序
	   function sortTime(colNum){ //参数为给第几列排序从0开始
		   var tabNode = document.getElementsByTagName("table")[0];
		   var trNodes = tabNode.rows; //获取表格中的行对象
		   var arr = new Array();
		   for(var x=1;x<trNodes.length;x++){ //临时容器存入的是表格中行对象的引用
				//alert(trNodes[x].childNodes[3].innerHTML+'*') ;
				arr[x-1] = parseInt(trNodes[x].childNodes[colNum].innerHTML);
		   }
		   return bubbleSort(arr);
	   }
	   //冒泡排序  返回最大值
	  function bubbleSort(arr){
	        var len=arr.length, tmp;
	        for(var i=0;i<len-1;i++){
	            for(var j=0;j<len-1-i;j++){
	                if(arr[j]>arr[j+1]){
	                    tmp = arr[j];
	                    arr[j] = arr[j+1];
	                    arr[j+1] = tmp;
	                }
	            }
	        }
	        return arr[arr.length-1];
	    }
	   