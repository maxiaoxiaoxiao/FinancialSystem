/**
 * jquery.easymessager.js
 * 这是一个jQuery的插件，它可以让您轻松的在页面上创建消息，并推送给用户。
 * 
 * -- REQUIRE: jQuery --
 * 
 * @author	Hpyer
 * @home	http://hpyer.cn
 * @version	1.0
 * @release	2015-08-11
 */

/*
USAGE:

<html>
<head>
<script type="text/javascript" src="http://code.jquery.com/jquery-latest.js"></script>
<link rel="stylesheet" type="text/css" href="jquery.easymessager.css" />
<script type="text/javascript" src="jquery.easymessager.js"></script>
</head>
<body>
<script>$.easymessager('Test Message');</script>
</body>
</html>
*/

(function($) {
	var default_options = {
		'timeout' : 0,	// 自动关闭消息的秒数
		'classMessager' : 'easymessager',	// 消息的样式
		'classCloser' : 'easymessager-closer',	// 消息关闭按钮的样式
		'classMessage' : 'easymessager-message'	// 消息内容的样式
	};
	var messages_pool = {};

	var EasyMessager = {
		create: function(message, options) {
			// 当有新的消息时，将之前的消息全部取消自动关闭
			$.each(messages_pool, function(msg, timer) {
				clearTimeout(timer);
				messages_pool[msg] = null;
			});

			// 添加新的消息
			var options = $.extend({}, default_options, options);
			options.timeout = Math.abs(parseInt(options.timeout));
			var messager = $('<div data-role="easymessager" class="'+options.classMessager+'" style="display:none"><span data-role="easymessager-closer" class="'+options.classCloser+'">X</span><div data-role="easymessager-message" class="'+options.classMessage+'">'+message+'</div></div>');
			$(document.body).append(messager);
			messager.fadeIn('fast').find('[data-role=easymessager-closer]').bind('click', EasyMessager.close);
			if (options.timeout > 0) {
				messager.attr('data-timeout', options.timeout);
				messages_pool[escape(message)] = EasyMessager.autoClose(messager, options.timeout);
			}
		},

		close: function(e) {
			var messager;
			if (e.target && $(e.target).attr('data-role') == 'easymessager-closer') messager = $(e.target).parent();
			else messager = e;
			EasyMessager.remove(messager);
		},

		autoClose: function(messager, time) {
			return setTimeout(function() {
				EasyMessager.remove(messager);
			}, time * 1000);
		},

		remove: function(messager) {
			var message = escape(messager.find('[data-role=easymessager-message]').html());
			clearTimeout(messages_pool[message]);
			delete messages_pool[message];
			messager.fadeOut('fast', function() {
				messager.remove();

				// 前一个消息如果定义了自动关闭，则重新开始计时
				var last_messager = $('div[data-role=easymessager]');
				if (last_messager.size() == 0) return;
				last_messager = last_messager.last();
				var last_message = escape(last_messager.find('[data-role=easymessager-message]').html());
				var time = Math.abs(parseInt(last_messager.attr('data-timeout')));
				if (messages_pool[last_message] == null && time > 0) {
					EasyMessager.autoClose(last_messager, time);
				}
			});
		}
	};

	$.easymessager = function(message, options) {
		EasyMessager.create(message, options);
	};

	$.easymessager.set = function(options) {
		default_options = $.extend(default_options, options);
	};

})(jQuery);