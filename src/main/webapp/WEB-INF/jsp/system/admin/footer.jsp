<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!-- 页面底部 -->
	<div class="footer">
		<span>Copyright © 2015</span><span class="text-uppercase">版本v1.0</span><span>北京银资科技有限公司</span><span>客服电话：400-1234-000</span>
	</div> 
	
	<script>
	$(function(){
        function setW(){
        	//alert($(document).width());
            $(".footer").width($(window).width()-190);
        }
        setW();
        $(window).resize(function() {
            setW();
        });
    })
    </script>