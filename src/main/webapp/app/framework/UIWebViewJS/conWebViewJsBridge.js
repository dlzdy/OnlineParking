
//与ios交互
//这里初始化先是创建了一个connectWebViewJavascriptBridge方法，该方法注册了一个WebViewJavascriptBridgeReady事件，同时声明了一个全局的WebViewJavascriptBridge变量。我们可以在外部通过WebViewJavascriptBridge调用相关方法。
function connectWebViewJavascriptBridge(callback) {
		  if (window.WebViewJavascriptBridge) {
			    callback(WebViewJavascriptBridge)
		  } else {
		      	document.addEventListener('WebViewJavascriptBridgeReady', function() {
		    	  	callback(WebViewJavascriptBridge)
		        }, false)
		  }
	} 
	
// 在init里面同样有一个function，这个function同样是用来接收Objective-C里面通过send方法发送的消息的，参数与OC里的send方法参数对应
	connectWebViewJavascriptBridge(function(bridge) {
         bridge.init(function(message, responseCallback) {
                     responseCallback(data)
         })
    
	})

