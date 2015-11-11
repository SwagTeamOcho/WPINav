<!DOCTYPE html>
<html lang="en" >

<head>
	<script>
window.ts_endpoint_url = "https:\/\/slack.com\/beacon\/timing";
</script>
<script>
window.TSMark = function(mark_label) {
	if (!window.performance || !window.performance.mark) return;
	performance.mark(mark_label);
};
TSMark('start_load');


window.TSMeasureAndBeacon = function(measure_label, start_mark_label) {
	if (start_mark_label === 'start_nav' && window.performance && window.performance.timing) {
		TSBeacon(measure_label, (new Date()).getTime() - performance.timing.navigationStart);
		return;
	}
	if (!window.performance || !window.performance.mark || !window.performance.measure) return;
	performance.mark(start_mark_label + '_end');
	try {
		performance.measure(measure_label, start_mark_label, start_mark_label + '_end');
		TSBeacon(measure_label, performance.getEntriesByName(measure_label)[0].duration);
	} catch(e) { return; }
};


window.TSBeacon = function(label, value) {
	var endpoint_url = ts_endpoint_url || 'https://slack.com/beacon/timing';
	(new Image()).src = endpoint_url + '?data=' + encodeURIComponent(label + ':' + value);
};
</script>
	<noscript><meta http-equiv="refresh" content="0; URL=/files/lumbini/F0EBF25JN/mainstage.java?nojsmode=1" /></noscript>
<script type="text/javascript">
window.load_start_ms = Date.now();
window.load_log = [];
window.logLoad = function(k) {
	var ms = Date.now();
	var secs = (ms-window.load_start_ms)/1000;

	window.load_log.push({
		k: k,
		t: secs
	})
	
	if (window.TS) {
		TS.log(88, secs+' '+k);
	}
}
if(self!==top)window.document.write("\u003Cstyle>body * {display:none !important;}\u003C\/style>\u003Ca href=\"#\" onclick="+
"\"top.location.href=window.location.href\" style=\"display:block !important;padding:10px\">Go to Slack.com\u003C\/a>");
</script>


<script type="text/javascript">
window.callSlackAPIUnauthed = function(method, args, callback) {
	var url = '/api/'+method+'?t='+Date.now();
	var req = new XMLHttpRequest();
	
	req.onreadystatechange = function() {
		if (req.readyState == 4) {
			req.onreadystatechange = null;
			var obj;
			
			if (req.status == 200) {
				if (req.responseText.indexOf('{') == 0) {
					try {
						eval('obj = '+req.responseText);
					} catch (err) {
						console.warn('unable to do anything with api rsp');
					}
				}
			}
			
			obj = obj || {
				ok: false	
			}
			
			callback(obj.ok, obj, args);
		}
	}
	
	req.open('POST', url, 1);
	req.setRequestHeader('Content-Type', 'application/x-www-form-urlencoded');

	var args2 = [];
	for (i in args) {
		args2[args2.length] = encodeURIComponent(i)+'='+encodeURIComponent(args[i]);
	}

	req.send(args2.join('&'));
}
</script>

			
	
	<script type="text/javascript">
		(function(i,s,o,g,r,a,m){i['GoogleAnalyticsObject']=r;i[r]=i[r]||function(){
		(i[r].q=i[r].q||[]).push(arguments)},i[r].l=1*new Date();a=s.createElement(o),
		m=s.getElementsByTagName(o)[0];a.async=1;a.src=g;m.parentNode.insertBefore(a,m)
		})(window,document,'script','//www.google-analytics.com/analytics.js','ga');
		ga('create', "UA-106458-17", 'slack.com');
				ga('send', 'pageview');

		
		(function(e,c,b,f,d,g,a){e.SlackBeaconObject=d;
		e[d]=e[d]||function(){(e[d].q=e[d].q||[]).push([1*new Date(),arguments])};
		e[d].l=1*new Date();g=c.createElement(b);a=c.getElementsByTagName(b)[0];
		g.async=1;g.src=f;a.parentNode.insertBefore(g,a)
		})(window,document,"script","https://slack.global.ssl.fastly.net/dcf8/js/libs/beacon.js","sb");
		sb('set', 'token', '3307f436963e02d4f9eb85ce5159744c');

					sb('set', 'user_id', "U0DMKR466");
							sb('set', 'user_' + "batch", "?");
							sb('set', 'user_' + "created", "2015-11-02");
						sb('set', 'name_tag', "team-ocho" + '/' + "anruggiero");
				sb('track', 'pageview');

		function track(a){ga('send','event','web',a);sb('track',a);}

	</script>


		<script type='text/javascript'>
		
		(function(f,b){if(!b.__SV){var a,e,i,g;window.mixpanel=b;b._i=[];b.init=function(a,e,d){function f(b,h){var a=h.split(".");2==a.length&&(b=b[a[0]],h=a[1]);b[h]=function(){b.push([h].concat(Array.prototype.slice.call(arguments,0)))}}var c=b;"undefined"!==typeof d?c=b[d]=[]:d="mixpanel";c.people=c.people||[];c.toString=function(b){var a="mixpanel";"mixpanel"!==d&&(a+="."+d);b||(a+=" (stub)");return a};c.people.toString=function(){return c.toString(1)+".people (stub)"};i="disable track track_pageview track_links track_forms register register_once alias unregister identify name_tag set_config people.set people.set_once people.increment people.append people.track_charge people.clear_charges people.delete_user".split(" ");
		for(g=0;g<i.length;g++)f(c,i[g]);b._i.push([a,e,d])};b.__SV=1.2;a=f.createElement("script");a.type="text/javascript";a.async=!0;a.src="//cdn.mxpnl.com/libs/mixpanel-2-latest.min.js";e=f.getElementsByTagName("script")[0];e.parentNode.insertBefore(a,e)}})(document,window.mixpanel||[]);
		

		mixpanel.init("12d52d8633a5b432975592d13ebd3f34");

		
			function mixpanel_track(){if(window.mixpanel)mixpanel.track.apply(mixpanel, arguments);}
			function mixpanel_track_forms(){if(window.mixpanel)mixpanel.track_forms.apply(mixpanel, arguments);}
			function mixpanel_track_links(){if(window.mixpanel)mixpanel.track_links.apply(mixpanel, arguments);}
		
	</script>
	
			<meta name="referrer" content="no-referrer">
			<meta name="superfish" content="nofish">
	<script type="text/javascript">



var TS_last_log_date = null;
var TSMakeLogDate = function() {
	var date = new Date();

	var y = date.getFullYear();
	var mo = date.getMonth()+1;
	var d = date.getDate();

	var time = {
	  h: date.getHours(),
	  mi: date.getMinutes(),
	  s: date.getSeconds(),
	  ms: date.getMilliseconds()
	};

	Object.keys(time).map(function(moment, index) {
		if(time[moment] < 10) {
			time[moment] = '0' + time[moment];
		}
	});

	var str = y + '/' + mo + '/' + d + ' ' + time.h + ':' + time.mi + ':' + time.s + '.' + time.ms;
	if (TS_last_log_date) {
		var diff = date-TS_last_log_date;
		//str+= ' ('+diff+'ms)';
	}
	TS_last_log_date = date;
	return str+' ';
}

var TSSSB = {
	env: (function() {
		var v = {
			win_ssb_version: null,
			win_ssb_version_minor: null,
			mac_ssb_version: null,
			mac_ssb_version_minor: null,
			mac_ssb_build: null,
			lin_ssb_version: null,
			lin_ssb_version_minor: null
		}
		
		var is_win = (navigator.appVersion.indexOf("Windows") !== -1);
		var is_lin = (navigator.appVersion.indexOf("Linux") !== -1);
		var is_mac = !!(navigator.userAgent.match(/(OS X)/g));

		if (navigator.userAgent.match(/(Slack_SSB)/g) || navigator.userAgent.match(/(Slack_WINSSB)/g)) {
			// Mozilla/5.0 (Macintosh; Intel Mac OS X 10_6_8) AppleWebKit/534.55.3 (KHTML, like Gecko) Slack_SSB/0.32
			var parts = navigator.userAgent.split('/');
			var version_str = parts[parts.length-1];
			var version_float = parseFloat(version_str);
			var versionA = version_str.split('.');
			var version_minor = (versionA.length == 3) ? parseInt(versionA[2]) : 0;
	
			if (navigator.userAgent.match(/(AtomShell)/g)) {
				// Electron-based app
				if (is_lin) {
					v.lin_ssb_version = version_float;
					v.lin_ssb_version_minor = version_minor;
				} else {
					v.win_ssb_version = version_float;
					v.win_ssb_version_minor = version_minor;
				}
			} else {
				// MacGap-based app
				v.mac_ssb_version = version_float;
				v.mac_ssb_version_minor = version_minor;
				
				// buildVersion() only available in 2.0 + (and not early builds)
				// returns a string like "2.0.0 (7447)" and we want the part in parens
				var app_ver = window.macgap && macgap.app && macgap.app.buildVersion && macgap.app.buildVersion();
				var matches = String(app_ver).match(/(?:\()(.*)(?:\))/);
				v.mac_ssb_build = (matches && matches.length == 2) ? parseInt(matches[1] || 0) : 0;
			}
		}

		return v;
	})(),
	
	

	call: function() {
		return false;
	}

	
}

</script>	<script type="text/javascript">
		
		var was_TS = window.TS;
		delete window.TS;
		TSSSB.call('didFinishLoading');
		if (was_TS) window.TS = was_TS;
	</script>
	    <meta charset="utf-8">
    <title>MainStage.java | Team Ocho Slack</title>
    <meta name="author" content="Slack">

	
				
									
	

		
				<!-- output_css "core" -->
    <link href="https://slack.global.ssl.fastly.net/f315/style/rollup-plastic.css" rel="stylesheet" type="text/css">

		<!-- output_css "before_file_pages" -->
    <link href="https://slack.global.ssl.fastly.net/e9e7/style/libs/codemirror.css" rel="stylesheet" type="text/css">

	<!-- output_css "file_pages" -->
    <link href="https://slack.global.ssl.fastly.net/e7d4/style/rollup-file_pages.css" rel="stylesheet" type="text/css">

	<!-- output_css "regular" -->
    <link href="https://slack.global.ssl.fastly.net/e3b8/style/print.css" rel="stylesheet" type="text/css">
    <link href="https://slack.global.ssl.fastly.net/782b/style/libs/lato-1.css" rel="stylesheet" type="text/css">

	

	
	
	

	<!--[if lt IE 9]>
	<script src="https://slack.global.ssl.fastly.net/ef0d/js/libs/html5shiv.js"></script>
	<![endif]-->

	
<link id="favicon" rel="shortcut icon" href="https://slack.global.ssl.fastly.net/66f9/img/icons/favicon-32.png" sizes="16x16 32x32 48x48" type="image/png" />

<link rel="icon" href="https://slack.global.ssl.fastly.net/ba3c/img/icons/app-256.png" sizes="256x256" type="image/png" />

<link rel="apple-touch-icon-precomposed" sizes="152x152" href="https://slack.global.ssl.fastly.net/66f9/img/icons/ios-152.png" />
<link rel="apple-touch-icon-precomposed" sizes="144x144" href="https://slack.global.ssl.fastly.net/66f9/img/icons/ios-144.png" />
<link rel="apple-touch-icon-precomposed" sizes="120x120" href="https://slack.global.ssl.fastly.net/66f9/img/icons/ios-120.png" />
<link rel="apple-touch-icon-precomposed" sizes="114x114" href="https://slack.global.ssl.fastly.net/66f9/img/icons/ios-114.png" />
<link rel="apple-touch-icon-precomposed" sizes="72x72" href="https://slack.global.ssl.fastly.net/0dc1/img/icons/ios-72.png" />
<link rel="apple-touch-icon-precomposed" href="https://slack.global.ssl.fastly.net/66f9/img/icons/ios-57.png" />

<meta name="msapplication-TileColor" content="#FFFFFF" />
<meta name="msapplication-TileImage" content="https://slack.global.ssl.fastly.net/66f9/img/icons/app-144.png" />	<script>
!function(a,b){function c(a,b){try{if("function"!=typeof a)return a;if(!a.bugsnag){var c=e();a.bugsnag=function(d){if(b&&b.eventHandler&&(u=d),v=c,!y){var e=a.apply(this,arguments);return v=null,e}try{return a.apply(this,arguments)}catch(f){throw l("autoNotify",!0)&&(x.notifyException(f,null,null,"error"),s()),f}finally{v=null}},a.bugsnag.bugsnag=a.bugsnag}return a.bugsnag}catch(d){return a}}function d(){B=!1}function e(){var a=document.currentScript||v;if(!a&&B){var b=document.scripts||document.getElementsByTagName("script");a=b[b.length-1]}return a}function f(a){var b=e();b&&(a.script={src:b.src,content:l("inlineScript",!0)?b.innerHTML:""})}function g(b){var c=l("disableLog"),d=a.console;void 0===d||void 0===d.log||c||d.log("[Bugsnag] "+b)}function h(b,c,d){if(d>=5)return encodeURIComponent(c)+"=[RECURSIVE]";d=d+1||1;try{if(a.Node&&b instanceof a.Node)return encodeURIComponent(c)+"="+encodeURIComponent(r(b));var e=[];for(var f in b)if(b.hasOwnProperty(f)&&null!=f&&null!=b[f]){var g=c?c+"["+f+"]":f,i=b[f];e.push("object"==typeof i?h(i,g,d):encodeURIComponent(g)+"="+encodeURIComponent(i))}return e.join("&")}catch(j){return encodeURIComponent(c)+"="+encodeURIComponent(""+j)}}function i(a,b){if(null==b)return a;a=a||{};for(var c in b)if(b.hasOwnProperty(c))try{a[c]=b[c].constructor===Object?i(a[c],b[c]):b[c]}catch(d){a[c]=b[c]}return a}function j(a,b){a+="?"+h(b)+"&ct=img&cb="+(new Date).getTime();var c=new Image;c.src=a}function k(a){var b={},c=/^data\-([\w\-]+)$/;if(a)for(var d=a.attributes,e=0;e<d.length;e++){var f=d[e];if(c.test(f.nodeName)){var g=f.nodeName.match(c)[1];b[g]=f.value||f.nodeValue}}return b}function l(a,b){C=C||k(J);var c=void 0!==x[a]?x[a]:C[a.toLowerCase()];return"false"===c&&(c=!1),void 0!==c?c:b}function m(a){return a&&a.match(D)?!0:(g("Invalid API key '"+a+"'"),!1)}function n(b,c){var d=l("apiKey");if(m(d)&&A){A-=1;var e=l("releaseStage"),f=l("notifyReleaseStages");if(f){for(var h=!1,k=0;k<f.length;k++)if(e===f[k]){h=!0;break}if(!h)return}var n=[b.name,b.message,b.stacktrace].join("|");if(n!==w){w=n,u&&(c=c||{},c["Last Event"]=q(u));var o={notifierVersion:H,apiKey:d,projectRoot:l("projectRoot")||a.location.protocol+"//"+a.location.host,context:l("context")||a.location.pathname,userId:l("userId"),user:l("user"),metaData:i(i({},l("metaData")),c),releaseStage:e,appVersion:l("appVersion"),url:a.location.href,userAgent:navigator.userAgent,language:navigator.language||navigator.userLanguage,severity:b.severity,name:b.name,message:b.message,stacktrace:b.stacktrace,file:b.file,lineNumber:b.lineNumber,columnNumber:b.columnNumber,payloadVersion:"2"},p=x.beforeNotify;if("function"==typeof p){var r=p(o,o.metaData);if(r===!1)return}return 0===o.lineNumber&&/Script error\.?/.test(o.message)?g("Ignoring cross-domain script error. See https://bugsnag.com/docs/notifiers/js/cors"):(j(l("endpoint")||G,o),void 0)}}}function o(){var a,b,c=10,d="[anonymous]";try{throw new Error("")}catch(e){a="<generated>\n",b=p(e)}if(!b){a="<generated-ie>\n";var f=[];try{for(var h=arguments.callee.caller.caller;h&&f.length<c;){var i=E.test(h.toString())?RegExp.$1||d:d;f.push(i),h=h.caller}}catch(j){g(j)}b=f.join("\n")}return a+b}function p(a){return a.stack||a.backtrace||a.stacktrace}function q(a){var b={millisecondsAgo:new Date-a.timeStamp,type:a.type,which:a.which,target:r(a.target)};return b}function r(a){if(a){var b=a.attributes;if(b){for(var c="<"+a.nodeName.toLowerCase(),d=0;d<b.length;d++)b[d].value&&"null"!=b[d].value.toString()&&(c+=" "+b[d].name+'="'+b[d].value+'"');return c+">"}return a.nodeName}}function s(){z+=1,a.setTimeout(function(){z-=1})}function t(a,b,c){var d=a[b],e=c(d);a[b]=e}var u,v,w,x={},y=!0,z=0,A=10;x.noConflict=function(){return a.Bugsnag=b,x},x.refresh=function(){A=10},x.notifyException=function(a,b,c,d){b&&"string"!=typeof b&&(c=b,b=void 0),c||(c={}),f(c),n({name:b||a.name,message:a.message||a.description,stacktrace:p(a)||o(),file:a.fileName||a.sourceURL,lineNumber:a.lineNumber||a.line,columnNumber:a.columnNumber?a.columnNumber+1:void 0,severity:d||"warning"},c)},x.notify=function(b,c,d,e){n({name:b,message:c,stacktrace:o(),file:a.location.toString(),lineNumber:1,severity:e||"warning"},d)};var B="complete"!==document.readyState;document.addEventListener?(document.addEventListener("DOMContentLoaded",d,!0),a.addEventListener("load",d,!0)):a.attachEvent("onload",d);var C,D=/^[0-9a-f]{32}$/i,E=/function\s*([\w\-$]+)?\s*\(/i,F="https://notify.bugsnag.com/",G=F+"js",H="2.4.7",I=document.getElementsByTagName("script"),J=I[I.length-1];if(a.atob){if(a.ErrorEvent)try{0===new a.ErrorEvent("test").colno&&(y=!1)}catch(K){}}else y=!1;if(l("autoNotify",!0)){t(a,"onerror",function(b){return function(c,d,e,g,h){var i=l("autoNotify",!0),j={};!g&&a.event&&(g=a.event.errorCharacter),f(j),v=null,i&&!z&&n({name:h&&h.name||"window.onerror",message:c,file:d,lineNumber:e,columnNumber:g,stacktrace:h&&p(h)||o(),severity:"error"},j),b&&b(c,d,e,g,h)}});var L=function(a){return function(b,d){if("function"==typeof b){b=c(b);var e=Array.prototype.slice.call(arguments,2);return a(function(){b.apply(this,e)},d)}return a(b,d)}};t(a,"setTimeout",L),t(a,"setInterval",L),a.requestAnimationFrame&&t(a,"requestAnimationFrame",function(a){return function(b){return a(c(b))}}),a.setImmediate&&t(a,"setImmediate",function(a){return function(){var b=Array.prototype.slice.call(arguments);return b[0]=c(b[0]),a.apply(this,b)}}),"EventTarget Window Node ApplicationCache AudioTrackList ChannelMergerNode CryptoOperation EventSource FileReader HTMLUnknownElement IDBDatabase IDBRequest IDBTransaction KeyOperation MediaController MessagePort ModalWindow Notification SVGElementInstance Screen TextTrack TextTrackCue TextTrackList WebSocket WebSocketWorker Worker XMLHttpRequest XMLHttpRequestEventTarget XMLHttpRequestUpload".replace(/\w+/g,function(b){var d=a[b]&&a[b].prototype;d&&d.hasOwnProperty&&d.hasOwnProperty("addEventListener")&&(t(d,"addEventListener",function(a){return function(b,d,e,f){return d&&d.handleEvent&&(d.handleEvent=c(d.handleEvent,{eventHandler:!0})),a.call(this,b,c(d,{eventHandler:!0}),e,f)}}),t(d,"removeEventListener",function(a){return function(b,d,e,f){return a.call(this,b,d,e,f),a.call(this,b,c(d),e,f)}}))})}a.Bugsnag=x,"function"==typeof define&&define.amd?define([],function(){return x}):"object"==typeof module&&"object"==typeof module.exports&&(module.exports=x)}(window,window.Bugsnag);
Bugsnag.apiKey = "2a86b308af5a81d2c9329fedfb4b30c7";
Bugsnag.appVersion = "07a742e8dec652f8a2a70b99dbc6ea540ee2c68a" + '-' + "1447280868";
Bugsnag.endpoint = "https://errors-webapp.slack-core.com/js";
Bugsnag.releaseStage = "prod";
Bugsnag.autoNotify = false;
Bugsnag.user = {id:"U0DMKR466",name:"anruggiero",email:"anruggiero@wpi.edu"};
Bugsnag.metaData = {};
Bugsnag.metaData.team = {id:"T0DMJ48UE",name:"Team Ocho",domain:"team-ocho"};
Bugsnag.refresh_interval = setInterval(function () { (window.TS && window.TS.client) ? Bugsnag.refresh() : clearInterval(Bugsnag.refresh_interval); }, 15 * 60 * 1000);
</script>
</head>

<body class="">

		  			<script>
		
			var w = Math.max(document.documentElement.clientWidth, window.innerWidth || 0);
			if (w > 1440) document.querySelector('body').classList.add('widescreen');
		
		</script>
	
  	
	

			<nav id="site_nav" class="no_transition">

	<div id="site_nav_contents">

		<div id="user_menu">
			<div id="user_menu_contents">
				<div id="user_menu_avatar">
										<span class="member_image thumb_48" style="background-image: url('https://avatars.slack-edge.com/2015-11-02/13745378944_55c6741557cef1d3aab1_192.jpg')" data-thumb-size="48" data-member-id="U0DMKR466"></span>
					<span class="member_image thumb_36" style="background-image: url('https://avatars.slack-edge.com/2015-11-02/13745378944_55c6741557cef1d3aab1_72.jpg')" data-thumb-size="36" data-member-id="U0DMKR466"></span>
				</div>
				<h3>Signed in as</h3>
				<span id="user_menu_name">anruggiero</span>
			</div>
		</div>

		<div class="nav_contents">

			<ul class="primary_nav">
				<li><a href="/home"><i class="ts_icon ts_icon_home"></i>Home</a></li>
				<li><a href="/account"><i class="ts_icon ts_icon_user"></i>Account & Profile</a></li>
				<li><a href="/services/new"><i class="ts_icon ts_icon_plug"></i>Integrations</a></li>
				<li><a href="/archives"><i class="ts_icon ts_icon_inbox"></i>Message Archives</a></li>
				<li><a href="/files"><i class="ts_icon ts_icon_file"></i>Files</a></li>
				<li><a href="/team"><i class="ts_icon ts_icon_team_directory"></i>Team Directory</a></li>
									<li><a href="/stats"><i class="ts_icon ts_icon_dashboard"></i>Statistics</a></li>
													<li><a href="/customize"><i class="ts_icon ts_icon_magic"></i>Customize</a></li>
													<li><a href="/account/team"><i class="ts_icon ts_icon_cog_o"></i>Team Settings</a></li>
							</ul>

			
		</div>

		<div id="footer">

			<ul id="footer_nav">
				<li><a href="/is">Tour</a></li>
				<li><a href="/downloads">Download Apps</a></li>
				<li><a href="/brand-guidelines">Brand Guidelines</a></li>
				<li><a href="/help">Help</a></li>
				<li><a href="https://api.slack.com" target="_blank">API<i class="ts_icon ts_icon_external_link small_left_margin ts_icon_inherit"></i></a></li>
								<li><a href="/pricing">Pricing</a></li>
				<li><a href="/help/requests/new">Contact</a></li>
				<li><a href="/terms-of-service">Policies</a></li>
				<li><a href="http://slackhq.com/" target="_blank">Our Blog</a></li>
				<li><a href="https://slack.com/signout/13732144966?crumb=s-1447285393-ec4baf083c-%E2%98%83">Sign Out<i class="ts_icon ts_icon_sign_out small_left_margin ts_icon_inherit"></i></a></li>
			</ul>

			<p id="footer_signature">Made with <i class="ts_icon ts_icon_heart"></i> by Slack</p>

		</div>

	</div>
</nav>	
			<header>
							<a id="menu_toggle" class="no_transition">
					<span class="menu_icon"></span>
					<span class="menu_label">Menu</span>
					<span class="vert_divider"></span>
				</a>
				<h1 id="header_team_name" class="inline_block no_transition">
					<a href="/home">
						<i class="ts_icon ts_icon_home" /></i>
						Team Ocho
					</a>
				</h1>
				<div class="header_nav">
					<div class="header_btns float_right">
						<a id="team_switcher">
							<i class="ts_icon ts_icon_th_large ts_icon_inherit"></i>
							<span class="block label">Teams</span>
						</a>
						<a href="/help" id="help_link">
							<i class="ts_icon ts_icon_life_ring ts_icon_inherit"></i>
							<span class="block label">Help</span>
						</a>
						<a href="/messages">
							<img src="https://slack.global.ssl.fastly.net/66f9/img/icons/ios-64.png" srcset="https://slack.global.ssl.fastly.net/66f9/img/icons/ios-32.png 1x, https://slack.global.ssl.fastly.net/66f9/img/icons/ios-64.png 2x" />
							<span class="block label">Launch</span>
						</a>
					</div>
								                    <ul id="header_team_nav">
			                        			                            <li class="active">
			                            	<a href="https://team-ocho.slack.com/home" target="https://team-ocho.slack.com/">
			                            					                            			<i class="ts_icon ts_icon_check_circle_o active_icon"></i>
			                            					                            					                            			<i class="team_icon default" >TO</i>
			                            					                            		<span class="switcher_label team_name">Team Ocho</span>
			                            	</a>
			                            </li>
			                        			                        <li id="add_team_option"><a href="https://slack.com/signin" target="_blank"><i class="ts_icon ts_icon_plus team_icon"></i> <span class="switcher_label">Sign in to another team...</span></a></li>
			                    </ul>
			                				</div>
			
			
		</header>
	
	<div id="page" >

		<div id="page_contents" class="">

<p class="print_only">
	<strong>Created by lumbini on November 11, 2015 at 6:43 PM</strong><br />
	<span class="subtle_silver break_word">https://team-ocho.slack.com/files/lumbini/F0EBF25JN/mainstage.java</span>
</p>

<div class="file_header_container no_print"></div>

<div class="alert_container">
		<div class="file_public_link_shared alert" style="display: none;">
		
	<i class="ts_icon ts_icon_link"></i> Public Link: <a class="file_public_link" href="https://slack-files.com/T0DMJ48UE-F0EBF25JN-438022abee" target="new">https://slack-files.com/T0DMJ48UE-F0EBF25JN-438022abee</a>
</div></div>

<div id="file_page" class="card top_padding">

	<p class="small subtle_silver no_print meta">
		4KB Java snippet created on <span class="date">November 11th 2015</span>.
				<span class="file_share_list"></span>
	</p>

	<a id="file_action_cog" class="action_cog action_cog_snippet float_right no_print">
		<span>Actions </span><i class="ts_icon ts_icon_cog"></i>
	</a>
	<a id="snippet_expand_toggle" class="float_right no_print">
		<i class="ts_icon ts_icon_expand "></i>
		<i class="ts_icon ts_icon_compress hidden"></i>
	</a>

	<div class="large_bottom_margin clearfix">
		<pre id="file_contents">/**
* Created by Lumbini on 11/7/2015.
 * */

import java.awt.*;
import javax.swing.*;

public class MainStage extends JFrame
{
    public static void main(String[] args)
    {
        new MainStage();
    }
    public MainStage()
    {
        //This sets the size of the window
        this.setSize(1380, 950);
        Toolkit tk = Toolkit.getDefaultToolkit();
        Dimension dim = tk.getScreenSize();

        //Centers the window with respect to the screen size
        int xPos = (dim.width/2) - (this.getWidth()/2);
        int yPos = (dim.height/2) - (this.getHeight()/2);
        this.setLocation(xPos, yPos);
        this.setResizable(false);

        //Sets the close button
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setTitle(&quot;Get There&quot;);


        JPanel scenePanel = new JPanel();   //Holds all other Panels
        JPanel mapPanel = new JPanel();     //Displays the Map
        JPanel nodePanel = new JPanel();    //Displays the search box
        JPanel resultPanel = new JPanel();  //Displays the ETS, distance, turn by turn

        scenePanel.setLayout(new GridBagLayout());  //Uses Grid Bag Layout
        nodePanel.setLayout(new GridBagLayout());
        mapPanel.setLayout(new GridBagLayout());
        resultPanel.setLayout(new GridBagLayout());


        JLabel startLabel = new JLabel(&quot;Start&quot;);
        JLabel endLabel = new JLabel(&quot;End&quot;);
        JLabel mapLabel = new JLabel(&quot;Name of Map here&quot;);
        JLabel etaLabel = new JLabel(&quot;ETA: Time to destination will be displayed here&quot;);
        JLabel distanceLabel = new JLabel(&quot;Distance: Distance to Destination will be displayed here&quot;);
        JLabel instructLabel = new JLabel(&quot;Step by Step: &quot;);

        JButton searchButton = new JButton(&quot;Search&quot;);
        JButton switchButton = new JButton(&quot;Switch&quot;);

        JTextField startField = new JTextField(&quot;Starting Location...&quot;, 30);
        JTextField endField = new JTextField(&quot;End Location...&quot;, 30);

        JLabel wpiMap = new JLabel();
        wpiMap.setIcon(new ImageIcon(&quot;C:\\Users\\Lumbini\\Documents\\B Term\\Soft Eng\\WPINav\\src\\WPI Aerial view.jpg&quot;));

        addComp(nodePanel, startLabel, 0, 0, 1, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE);
        addComp(nodePanel, startField, 1, 0, 1, 1, GridBagConstraints.NORTHEAST, GridBagConstraints.NONE);
        addComp(nodePanel, endLabel, 0, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        addComp(nodePanel, endField, 1, 1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
        addComp(nodePanel, searchButton, 3, 0, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
        addComp(nodePanel, switchButton, 3, 1, 1, 1, GridBagConstraints.EAST, GridBagConstraints.NONE);
        addComp(mapPanel, mapLabel, 0, 0, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.NONE);
        addComp(mapPanel, wpiMap, 0, 1, 1, 1, GridBagConstraints.CENTER, GridBagConstraints.NONE);
        addComp(resultPanel, etaLabel, 0, 0, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        addComp(resultPanel, distanceLabel, 0, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);
        addComp(resultPanel, instructLabel, 0, 3, 1, 1, GridBagConstraints.NORTH, GridBagConstraints.NONE);

        addComp(scenePanel, resultPanel, 1, 0, 1, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE);
        addComp(scenePanel, nodePanel, 0, 0, 1, 1, GridBagConstraints.NORTHWEST, GridBagConstraints.NONE);
        addComp(scenePanel, mapPanel, 0, 1, 1, 1, GridBagConstraints.WEST, GridBagConstraints.NONE);

        this.add(scenePanel);
        this.setVisible(true);
    }

    private void addComp(JPanel thePanel, JComponent comp,
                         int xPos, int yPos, int compHeight, int compWidth, int place, int stretch)
    {
        GridBagConstraints gridConstraints = new GridBagConstraints();

        gridConstraints.gridx = xPos;
        gridConstraints.gridy = yPos;
        gridConstraints.gridwidth = compWidth;
        gridConstraints.gridheight = compHeight;
        gridConstraints.weightx = 500;
        gridConstraints.weighty = 5;
        gridConstraints.insets = new Insets(10, 10, 10, 10);
        gridConstraints.anchor = place;
        gridConstraints.fill = stretch;

        thePanel.add(comp, gridConstraints);
        validate();
    }
}</pre>

		<p class="file_page_meta no_print" style="line-height: 1.5rem;">
			<label class="checkbox normal mini float_right no_top_padding no_min_width">
				<input type="checkbox" id="file_preview_wrap_cb"> wrap long lines
			</label>
		</p>

	</div>

	<div id="comments_holder" class="clearfix clear_both">
	<div class="col span_1_of_6"></div>
	<div class="col span_4_of_6 no_right_padding">
		<div id="file_page_comments">
					</div>	
		<form action="https://team-ocho.slack.com/files/lumbini/F0EBF25JN/mainstage.java" 
		id="file_comment_form" 
					class="comment_form"
				method="post">
			<a href="/team/anruggiero" class="member_preview_link" data-member-id="U0DMKR466" >
			<span class="member_image thumb_36" style="background-image: url('https://avatars.slack-edge.com/2015-11-02/13745378944_55c6741557cef1d3aab1_72.jpg')" data-thumb-size="36" data-member-id="U0DMKR466"></span>
		</a>		
		<input type="hidden" name="addcomment" value="1" />
	<input type="hidden" name="crumb" value="s-1447285393-a16e34dca3-☃" />

	<textarea id="file_comment" data-el-id-to-keep-in-view="file_comment_submit_btn" class="small comment_input small_bottom_margin autogrow-short" name="comment" wrap="virtual" ></textarea>
	<span class="input_note float_left cloud_silver file_comment_tip">shift+enter to add a new line</span>	<button id="file_comment_submit_btn" type="submit" class="btn float_right  ladda-button" data-style="expand-right"><span class="ladda-label">Add Comment</span></button>
</form>

<form
		id="file_edit_comment_form" 
					class="edit_comment_form hidden"
				method="post">
		<textarea id="file_edit_comment" class="small comment_input small_bottom_margin" name="comment" wrap="virtual"></textarea><br>
	<span class="input_note float_left cloud_silver file_comment_tip">shift+enter to add a new line</span>	<input type="submit" class="save btn float_right " value="Save" />
	<button class="cancel btn btn_outline float_right small_right_margin ">Cancel</button>
</form>	
	</div>
	<div class="col span_1_of_6"></div>
</div>
</div>

	

		
	</div>
	<div id="overlay"></div>
</div>





<script type="text/javascript">
var cdn_url = "https:\/\/slack.global.ssl.fastly.net";
var inc_js_setup_data = {
	emoji_sheets: {
		apple: 'https://slack.global.ssl.fastly.net/d4bf/img/emoji_2015_2/sheet_apple_64_indexed_256colors.png',
		google: 'https://slack.global.ssl.fastly.net/d4bf/img/emoji_2015_2/sheet_google_64_indexed_128colors.png',
		twitter: 'https://slack.global.ssl.fastly.net/d4bf/img/emoji_2015_2/sheet_twitter_64_indexed_128colors.png',
		emojione: 'https://slack.global.ssl.fastly.net/d4bf/img/emoji_2015_2/sheet_emojione_64_indexed_128colors.png',
	},
};
</script>
			<script type="text/javascript">
<!--
	// common boot_data
	var boot_data = {
		start_ms: Date.now(),
		app: 'web',
		user_id: 'U0DMKR466',
		version_ts: '1447280868',
		version_uid: '07a742e8dec652f8a2a70b99dbc6ea540ee2c68a',
		cache_version: "v11-mouse",
		cache_ts_version: "v1-cat",
		redir_domain: 'slack-redir.net',
		signin_url: 'https://slack.com/signin',
		abs_root_url: 'https://slack.com/',
		api_url: '/api/',
		team_url: 'https://team-ocho.slack.com/',
		image_proxy_url: 'https://slack-imgs.com/',
		beacon_timing_url: "https:\/\/slack.com\/beacon\/timing",
		beacon_error_url: "https:\/\/slack.com\/beacon\/error",
		api_token: 'xoxs-13732144966-13733854210-13811135187-bb5a953596',

		feature_status: false,
		feature_archive_viewer: true,

		notification_sounds: [{"value":"b2.mp3","label":"Ding","url":"https:\/\/slack.global.ssl.fastly.net\/dfc0\/sounds\/push\/b2.mp3"},{"value":"animal_stick.mp3","label":"Boing","url":"https:\/\/slack.global.ssl.fastly.net\/dfc0\/sounds\/push\/animal_stick.mp3"},{"value":"been_tree.mp3","label":"Drop","url":"https:\/\/slack.global.ssl.fastly.net\/dfc0\/sounds\/push\/been_tree.mp3"},{"value":"complete_quest_requirement.mp3","label":"Ta-da","url":"https:\/\/slack.global.ssl.fastly.net\/dfc0\/sounds\/push\/complete_quest_requirement.mp3"},{"value":"confirm_delivery.mp3","label":"Plink","url":"https:\/\/slack.global.ssl.fastly.net\/dfc0\/sounds\/push\/confirm_delivery.mp3"},{"value":"flitterbug.mp3","label":"Wow","url":"https:\/\/slack.global.ssl.fastly.net\/dfc0\/sounds\/push\/flitterbug.mp3"},{"value":"here_you_go_lighter.mp3","label":"Here you go","url":"https:\/\/slack.global.ssl.fastly.net\/dfc0\/sounds\/push\/here_you_go_lighter.mp3"},{"value":"hi_flowers_hit.mp3","label":"Hi","url":"https:\/\/slack.global.ssl.fastly.net\/dfc0\/sounds\/push\/hi_flowers_hit.mp3"},{"value":"item_pickup.mp3","label":"Yoink","url":"https:\/\/slack.global.ssl.fastly.net\/dfc0\/sounds\/push\/item_pickup.mp3"},{"value":"knock_brush.mp3","label":"Knock Brush","url":"https:\/\/slack.global.ssl.fastly.net\/dfc0\/sounds\/push\/knock_brush.mp3"},{"value":"save_and_checkout.mp3","label":"Woah!","url":"https:\/\/slack.global.ssl.fastly.net\/dfc0\/sounds\/push\/save_and_checkout.mp3"},{"value":"none","label":"None (sound off)"}],
		alert_sounds: [{"value":"frog.mp3","label":"Frog","url":"https:\/\/slack.global.ssl.fastly.net\/a34a\/sounds\/frog.mp3"}],
		call_sounds: [{"value":"call\/alert.mp3","label":"Alert","url":"https:\/\/slack.global.ssl.fastly.net\/b6a68\/sounds\/call\/alert.mp3"},{"value":"call\/incoming_ring.mp3","label":"Incoming ring","url":"https:\/\/slack.global.ssl.fastly.net\/b6a68\/sounds\/call\/incoming_ring.mp3"},{"value":"call\/outgoing_ring.mp3","label":"Outgoing ring","url":"https:\/\/slack.global.ssl.fastly.net\/b6a68\/sounds\/call\/outgoing_ring.mp3"},{"value":"call\/pop.mp3","label":"Incoming reaction","url":"https:\/\/slack.global.ssl.fastly.net\/fa957\/sounds\/call\/pop.mp3"},{"value":"call\/they_left_call.mp3","label":"They left call","url":"https:\/\/slack.global.ssl.fastly.net\/b6a68\/sounds\/call\/they_left_call.mp3"},{"value":"call\/you_left_call.mp3","label":"You left call","url":"https:\/\/slack.global.ssl.fastly.net\/b6a68\/sounds\/call\/you_left_call.mp3"},{"value":"call\/they_joined_call.mp3","label":"They joined call","url":"https:\/\/slack.global.ssl.fastly.net\/b6a68\/sounds\/call\/they_joined_call.mp3"},{"value":"call\/you_joined_call.mp3","label":"You joined call","url":"https:\/\/slack.global.ssl.fastly.net\/b6a68\/sounds\/call\/you_joined_call.mp3"}],

		feature_api_extended_2fa_backup: false,
		feature_member_viz_perf: false,
		feature_message_replies: false,
		feature_mpim_client: true,
		feature_new_message_markup: false,
		feature_ui_reference_v2: false,
		feature_fs_prefs: false,
		feature_setactive_use_ms: true,
		feature_payments_stripe: true,
		feature_strike: true,
		feature_show_version_info: false,
		feature_ephemeral_attachments: false,
		feature_varietypack_optin: true,
		feature_deprecate_url_download: false,
		feature_rxn_skin_tone_modifiers: true,
		feature_all_skin_tones: false,
		feature_help_case_feedback: true,
		feature_spaces: true,
		feature_pass_the_baton: false,
		feature_a11y_keyboard_shortcuts: false,
		feature_email_integration: true,
		feature_email_ingestion: false,
		feature_attachments_inline: false,
		feature_fix_files: true,
		feature_files_list: true,
		feature_chat_sounds: false,
		feature_image_proxy: true,
		feature_channel_eventlog_client: true,
		feature_macssb1_banner: true,
		feature_winssb1_banner: true,
		feature_winssb_beta_channel: false,
		feature_latest_event_ts: true,
		feature_elide_closed_dms: true,
		feature_client_allow_demand_fetching: true,
		feature_no_redirects_in_ssb: true,
		feature_referer_policy: true,
		feature_client_exif_orientation_on_uploads: true,
		feature_pricing_page_tweet_carousel: true,
		feature_archived_channels_in_quick_switcher: false,
		feature_more_field_in_message_attachments: false,
		feature_user_hidden_msgs: false,
		feature_file_url_private_conversion: false,
		feature_screenhero: false,
		feature_custom_fields: true,
		feature_in_app_photo: false,
		feature_integrations_message_preview: false,
		feature_enterprise_api: false,
		feature_lite_to_free: true,
		feature_bot_profile: false,
		feature_two_factor_via_sms: true,
		feature_two_factor_for_teams: true,
		feature_slackbot_confirm_signup_email: true,
		feature_signup_invite_step: false,
		feature_separate_private_channels: true,
		feature_private_channels: true,
		feature_mpim_restrictions: false,
		feature_filter_select_component: true,
		feature_subteams: true,
		feature_subteams_hard_delete: false,
		feature_no_unread_counts: true,
		feature_web_cache_users: false,
		feature_command_list_metadata: true,
		feature_slack_command_button_use: true,
		feature_slack_command_button_create: true,
		feature_js_raf_queue: false,
		feature_downloads_enhancements: true,
		feature_admin_integration_settings: true,
		feature_marketing_video_getting_started: true,
		feature_getvisibletopbanners_performance: false,
		feature_channel_page_perf: false,
		feature_shared_channels: false,
		feature_fast_files_flexpane: false,
		feature_no_has_files: true,
		feature_tab_complete_search_changed: false,
		feature_whats_new: true,
		feature_log_client_errors_to_elk: false,
		feature_custom_saml_signin_button_label: false,
		feature_subteams_auto_suggest: true,
		feature_dnd_client: false,
		feature_file_viewer: false,
		feature_fix_thumbsup_sorting: true,

		img: {
			app_icon: 'https://slack.global.ssl.fastly.net/272a/img/slack_growl_icon.png'
		},
		page_needs_custom_emoji: false
	};



	// client boot data
			boot_data.login_data = {"ok":true,"self":{"id":"U0DMKR466","name":"anruggiero","prefs":{"highlight_words":"","user_colors":"","color_names_in_list":true,"growls_enabled":true,"tz":"America\/Indiana\/Indianapolis","push_dm_alert":true,"push_mention_alert":true,"push_everything":true,"push_idle_wait":2,"push_sound":"b2.mp3","push_loud_channels":"","push_mention_channels":"","push_loud_channels_set":"","email_alerts":"none","email_alerts_sleep_until":0,"email_misc":true,"email_weekly":true,"welcome_message_hidden":false,"all_channels_loud":true,"loud_channels":"","never_channels":"","loud_channels_set":"","show_member_presence":true,"search_sort":"timestamp","expand_inline_imgs":true,"expand_internal_inline_imgs":true,"expand_snippets":false,"posts_formatting_guide":true,"seen_welcome_2":true,"seen_ssb_prompt":false,"seen_spaces_new_xp_tooltip":false,"spaces_new_xp_banner_dismissed":false,"search_only_my_channels":false,"emoji_mode":"default","emoji_use":"{}","has_invited":false,"has_uploaded":true,"has_created_channel":true,"search_exclude_channels":"","messages_theme":"default","webapp_spellcheck":true,"no_joined_overlays":false,"no_created_overlays":false,"dropbox_enabled":false,"seen_domain_invite_reminder":false,"seen_member_invite_reminder":false,"mute_sounds":false,"arrow_history":false,"tab_ui_return_selects":true,"obey_inline_img_limit":true,"new_msg_snd":"knock_brush.mp3","collapsible":false,"collapsible_by_click":true,"require_at":false,"ssb_space_window":"","mac_ssb_bounce":"","mac_ssb_bullet":true,"expand_non_media_attachments":true,"show_typing":true,"pagekeys_handled":true,"last_snippet_type":"","display_real_names_override":0,"time24":false,"enter_is_special_in_tbt":false,"graphic_emoticons":false,"convert_emoticons":true,"autoplay_chat_sounds":true,"ss_emojis":true,"sidebar_behavior":"","seen_onboarding_start":true,"onboarding_cancelled":true,"seen_onboarding_slackbot_conversation":false,"seen_onboarding_channels":false,"seen_onboarding_direct_messages":false,"seen_onboarding_invites":false,"seen_onboarding_search":false,"seen_onboarding_recent_mentions":false,"seen_onboarding_starred_items":false,"seen_onboarding_private_groups":false,"onboarding_slackbot_conversation_step":1,"mark_msgs_read_immediately":true,"start_scroll_at_oldest":true,"snippet_editor_wrap_long_lines":false,"ls_disabled":false,"sidebar_theme":"default","sidebar_theme_custom_values":"","f_key_search":false,"k_key_omnibox":true,"speak_growls":false,"mac_speak_voice":"com.apple.speech.synthesis.voice.Alex","mac_speak_speed":250,"comma_key_prefs":false,"at_channel_suppressed_channels":"","push_at_channel_suppressed_channels":"","prompted_for_email_disabling":false,"full_text_extracts":false,"no_text_in_notifications":false,"muted_channels":"","no_macssb1_banner":false,"no_winssb1_banner":false,"no_omnibox_in_channels":false,"k_key_omnibox_auto_hide_count":0,"hide_user_group_info_pane":false,"mentions_exclude_at_user_groups":false,"privacy_policy_seen":true,"search_exclude_bots":false,"fuzzy_matching":false,"load_lato_2":false,"fuller_timestamps":false,"last_seen_at_channel_warning":0,"flex_resize_window":false,"msg_preview":false,"msg_preview_displaces":true,"msg_preview_persistent":true,"emoji_autocomplete_big":false,"winssb_run_from_tray":true,"winssb_window_flash_behavior":"idle","two_factor_auth_enabled":false,"two_factor_type":null,"two_factor_backup_type":null,"mentions_exclude_at_channels":true,"confirm_clear_all_unreads":true,"confirm_user_marked_away":true,"box_enabled":false,"seen_single_emoji_msg":false,"confirm_sh_call_start":true,"preferred_skin_tone":"","show_all_skin_tones":false,"msg_replies":"{ \"overlay\":false }","separate_private_channels":false,"whats_new_read":1446501063},"created":1446501063},"team":{"id":"T0DMJ48UE","name":"Team Ocho","email_domain":"","domain":"team-ocho","msg_edit_window_mins":-1,"prefs":{"default_channels":["C0DMJ494N","C0DMK87B2"],"msg_edit_window_mins":-1,"allow_message_deletion":true,"hide_referers":true,"display_real_names":false,"who_can_at_everyone":"regular","who_can_at_channel":"ra","warn_before_at_channel":"always","who_can_create_channels":"regular","who_can_archive_channels":"regular","who_can_create_groups":"ra","who_can_post_general":"ra","who_can_kick_channels":"admin","who_can_kick_groups":"regular","who_can_create_delete_user_groups":"admin","who_can_edit_user_groups":"admin","who_can_change_team_profile":"admin","retention_type":0,"retention_duration":0,"group_retention_type":0,"group_retention_duration":0,"dm_retention_type":0,"dm_retention_duration":0,"file_retention_type":0,"file_retention_duration":0,"require_at_for_mention":0,"compliance_export_start":0,"auth_mode":"normal","who_can_manage_integrations":{"type":["regular"]}},"icon":{"image_34":"https:\/\/slack.global.ssl.fastly.net\/66f9\/img\/avatars-teams\/ava_0003-34.png","image_44":"https:\/\/slack.global.ssl.fastly.net\/66f9\/img\/avatars-teams\/ava_0003-44.png","image_68":"https:\/\/slack.global.ssl.fastly.net\/66f9\/img\/avatars-teams\/ava_0003-68.png","image_88":"https:\/\/slack.global.ssl.fastly.net\/66f9\/img\/avatars-teams\/ava_0003-88.png","image_102":"https:\/\/slack.global.ssl.fastly.net\/66f9\/img\/avatars-teams\/ava_0003-102.png","image_132":"https:\/\/slack.global.ssl.fastly.net\/66f9\/img\/avatars-teams\/ava_0003-132.png","image_default":true},"over_storage_limit":false,"plan":"","profile":{"fields":[{"id":"Xf0DMJUBHQ","ordering":0,"label":"Skype","hint":"This will be displayed on your profile.","type":"text","possible_values":null,"options":null,"is_hidden":false}]},"over_integrations_limit":true},"latest_event_ts":"1447284793.000000","channels":[{"id":"C0DMJ494N","name":"general","is_channel":true,"created":1446500314,"creator":"U0DME3K37","is_archived":false,"is_general":true,"has_pins":false,"is_member":true,"members":["U0DME3K37","U0DMKR466","U0DMS3WMB","U0DMWCKHC","U0DN53BC0","U0DP3RJ3U","U0DUH3YFP","U0E1TUA6R"],"topic":{"value":"Company-wide announcements and work-based matters","creator":"","last_set":0},"purpose":{"value":"This channel is for team-wide communication and announcements. All team members are in this channel.","creator":"","last_set":0}},{"id":"C0DMW5G87","name":"github1","is_channel":true,"created":1446512711,"creator":"U0DMKR466","is_archived":false,"is_general":false,"has_pins":false,"is_member":true,"members":["U0DMKR466"],"topic":{"value":"","creator":"","last_set":0},"purpose":{"value":"Linking Github","creator":"U0DMKR466","last_set":1446512711}},{"id":"C0DV8URGQ","name":"path-planning","is_channel":true,"created":1446763631,"creator":"U0DP3RJ3U","is_archived":false,"is_general":false,"has_pins":false,"is_member":false},{"id":"C0DMGLX1A","name":"project-deliverables-","is_channel":true,"created":1446504164,"creator":"U0DMKR466","is_archived":false,"is_general":false,"has_pins":false,"is_member":true,"members":["U0DMKR466"],"topic":{"value":"","creator":"","last_set":0},"purpose":{"value":"","creator":"","last_set":0}},{"id":"C0DMK87B2","name":"random","is_channel":true,"created":1446500314,"creator":"U0DME3K37","is_archived":false,"is_general":false,"has_pins":false,"is_member":true,"members":["U0DME3K37","U0DMKR466","U0DMS3WMB","U0DMWCKHC","U0DN53BC0","U0DP3RJ3U","U0DUH3YFP","U0E1TUA6R"],"topic":{"value":"Non-work banter and water cooler conversation","creator":"","last_set":0},"purpose":{"value":"A place for non-work-related flimflam, faffing, hodge-podge or jibber-jabber you'd prefer to keep out of more focused work-related channels.","creator":"","last_set":0}},{"id":"C0E1YGJDA","name":"referencelinks","is_channel":true,"created":1446846272,"creator":"U0DN53BC0","is_archived":false,"is_general":false,"has_pins":false,"is_member":false},{"id":"C0DMPCL1Y","name":"survey","is_channel":true,"created":1446504103,"creator":"U0DMKR466","is_archived":false,"is_general":false,"has_pins":false,"is_member":true,"members":["U0DMKR466"],"topic":{"value":"","creator":"","last_set":0},"purpose":{"value":"","creator":"","last_set":0}},{"id":"C0DV3KNQ5","name":"ui-design","is_channel":true,"created":1446763466,"creator":"U0DMKR466","is_archived":false,"is_general":false,"has_pins":false,"is_member":true,"members":["U0DMKR466"],"topic":{"value":"","creator":"","last_set":0},"purpose":{"value":"Create a User Interface for the application","creator":"U0DMKR466","last_set":1446763466}}],"groups":[],"ims":[{"id":"D0DMG9K0B","is_im":true,"user":"USLACKBOT","created":1446501063,"has_pins":false,"is_user_deleted":false},{"id":"D0DMJR16V","is_im":true,"user":"U0DME3K37","created":1446501063,"has_pins":false,"is_user_deleted":false},{"id":"D0DMX8HNU","is_im":true,"user":"U0DMS3WMB","created":1446512739,"has_pins":false,"is_user_deleted":false},{"id":"D0DMTMWCT","is_im":true,"user":"U0DMWCKHC","created":1446513176,"has_pins":false,"is_user_deleted":false},{"id":"D0DN4QMRQ","is_im":true,"user":"U0DN53BC0","created":1446525140,"has_pins":false,"is_user_deleted":false},{"id":"D0DP31NTH","is_im":true,"user":"U0DP3RJ3U","created":1446565588,"has_pins":false,"is_user_deleted":false},{"id":"D0DUNA1T2","is_im":true,"user":"U0DUH3YFP","created":1446748093,"has_pins":false,"is_user_deleted":false},{"id":"D0E1V44E7","is_im":true,"user":"U0E1TUA6R","created":1446840834,"has_pins":false,"is_user_deleted":false}],"cache_ts":1447285393,"mpims":[],"subteams":{"self":[],"all":[]},"users":[{"id":"U0DMKR466","team_id":"T0DMJ48UE","name":"anruggiero","deleted":false,"status":null,"color":"4bbe2e","real_name":"Alex Ruggiero","tz":"America\/Indiana\/Indianapolis","tz_label":"Eastern Standard Time","tz_offset":-18000,"profile":{"first_name":"Alex","fields":{"Xf0DMJUBHQ":{"value":"","alt":""}},"last_name":"Ruggiero","title":"RBE","skype":"","phone":"8567232901","image_24":"https:\/\/avatars.slack-edge.com\/2015-11-02\/13745378944_55c6741557cef1d3aab1_24.jpg","image_32":"https:\/\/avatars.slack-edge.com\/2015-11-02\/13745378944_55c6741557cef1d3aab1_32.jpg","image_48":"https:\/\/avatars.slack-edge.com\/2015-11-02\/13745378944_55c6741557cef1d3aab1_48.jpg","image_72":"https:\/\/avatars.slack-edge.com\/2015-11-02\/13745378944_55c6741557cef1d3aab1_72.jpg","image_192":"https:\/\/avatars.slack-edge.com\/2015-11-02\/13745378944_55c6741557cef1d3aab1_192.jpg","image_512":"https:\/\/avatars.slack-edge.com\/2015-11-02\/13745378944_55c6741557cef1d3aab1_512.jpg","image_1024":"https:\/\/avatars.slack-edge.com\/2015-11-02\/13745378944_55c6741557cef1d3aab1_512.jpg","image_original":"https:\/\/avatars.slack-edge.com\/2015-11-02\/13745378944_55c6741557cef1d3aab1_original.jpg","real_name":"Alex Ruggiero","real_name_normalized":"Alex Ruggiero","email":"anruggiero@wpi.edu"},"is_admin":false,"is_owner":false,"is_primary_owner":false,"is_restricted":false,"is_ultra_restricted":false,"is_bot":false},{"id":"U0DUH3YFP","team_id":"T0DMJ48UE","name":"csgriffin","deleted":false,"status":null,"color":"e0a729","real_name":"","tz":"America\/Indiana\/Indianapolis","tz_label":"Eastern Standard Time","tz_offset":-18000,"profile":{"real_name":"","real_name_normalized":"","email":"csgriffin@wpi.edu","image_24":"https:\/\/secure.gravatar.com\/avatar\/b1a12d7a68c259eaccfddc58ef172951.jpg?s=24&d=https%3A%2F%2Fslack.global.ssl.fastly.net%2F66f9%2Fimg%2Favatars%2Fava_0019-24.png","image_32":"https:\/\/secure.gravatar.com\/avatar\/b1a12d7a68c259eaccfddc58ef172951.jpg?s=32&d=https%3A%2F%2Fslack.global.ssl.fastly.net%2F66f9%2Fimg%2Favatars%2Fava_0019-32.png","image_48":"https:\/\/secure.gravatar.com\/avatar\/b1a12d7a68c259eaccfddc58ef172951.jpg?s=48&d=https%3A%2F%2Fslack.global.ssl.fastly.net%2F66f9%2Fimg%2Favatars%2Fava_0019-48.png","image_72":"https:\/\/secure.gravatar.com\/avatar\/b1a12d7a68c259eaccfddc58ef172951.jpg?s=72&d=https%3A%2F%2Fslack.global.ssl.fastly.net%2F66f9%2Fimg%2Favatars%2Fava_0019-72.png","image_192":"https:\/\/secure.gravatar.com\/avatar\/b1a12d7a68c259eaccfddc58ef172951.jpg?s=192&d=https%3A%2F%2Fslack.global.ssl.fastly.net%2F7fa9%2Fimg%2Favatars%2Fava_0019-192.png","image_512":"https:\/\/secure.gravatar.com\/avatar\/b1a12d7a68c259eaccfddc58ef172951.jpg?s=512&d=https%3A%2F%2Fslack.global.ssl.fastly.net%2F7fa9%2Fimg%2Favatars%2Fava_0019-512.png","fields":null},"is_admin":false,"is_owner":false,"is_primary_owner":false,"is_restricted":false,"is_ultra_restricted":false,"is_bot":false},{"id":"U0DMS3WMB","team_id":"T0DMJ48UE","name":"jjchaves","deleted":false,"status":null,"color":"e7392d","real_name":"","tz":"America\/Indiana\/Indianapolis","tz_label":"Eastern Standard Time","tz_offset":-18000,"profile":{"image_24":"https:\/\/avatars.slack-edge.com\/2015-11-06\/14059478373_51aef53071abdaab2739_24.jpg","image_32":"https:\/\/avatars.slack-edge.com\/2015-11-06\/14059478373_51aef53071abdaab2739_32.jpg","image_48":"https:\/\/avatars.slack-edge.com\/2015-11-06\/14059478373_51aef53071abdaab2739_48.jpg","image_72":"https:\/\/avatars.slack-edge.com\/2015-11-06\/14059478373_51aef53071abdaab2739_72.jpg","image_192":"https:\/\/avatars.slack-edge.com\/2015-11-06\/14059478373_51aef53071abdaab2739_192.jpg","image_512":"https:\/\/avatars.slack-edge.com\/2015-11-06\/14059478373_51aef53071abdaab2739_192.jpg","image_1024":"https:\/\/avatars.slack-edge.com\/2015-11-06\/14059478373_51aef53071abdaab2739_192.jpg","image_original":"https:\/\/avatars.slack-edge.com\/2015-11-06\/14059478373_51aef53071abdaab2739_original.jpg","real_name":"","real_name_normalized":"","email":"jjchaves@wpi.edu","fields":null},"is_admin":false,"is_owner":false,"is_primary_owner":false,"is_restricted":false,"is_ultra_restricted":false,"is_bot":false},{"id":"U0E1TUA6R","team_id":"T0DMJ48UE","name":"jtkaiser","deleted":false,"status":null,"color":"684b6c","real_name":"","tz":"America\/Indiana\/Indianapolis","tz_label":"Eastern Standard Time","tz_offset":-18000,"profile":{"real_name":"","real_name_normalized":"","email":"jtkaiser@wpi.edu","image_24":"https:\/\/secure.gravatar.com\/avatar\/3751438447930aa8569f0c9a2c421f2a.jpg?s=24&d=https%3A%2F%2Fslack.global.ssl.fastly.net%2F66f9%2Fimg%2Favatars%2Fava_0003-24.png","image_32":"https:\/\/secure.gravatar.com\/avatar\/3751438447930aa8569f0c9a2c421f2a.jpg?s=32&d=https%3A%2F%2Fslack.global.ssl.fastly.net%2F66f9%2Fimg%2Favatars%2Fava_0003-32.png","image_48":"https:\/\/secure.gravatar.com\/avatar\/3751438447930aa8569f0c9a2c421f2a.jpg?s=48&d=https%3A%2F%2Fslack.global.ssl.fastly.net%2F66f9%2Fimg%2Favatars%2Fava_0003-48.png","image_72":"https:\/\/secure.gravatar.com\/avatar\/3751438447930aa8569f0c9a2c421f2a.jpg?s=72&d=https%3A%2F%2Fslack.global.ssl.fastly.net%2F66f9%2Fimg%2Favatars%2Fava_0003-72.png","image_192":"https:\/\/secure.gravatar.com\/avatar\/3751438447930aa8569f0c9a2c421f2a.jpg?s=192&d=https%3A%2F%2Fslack.global.ssl.fastly.net%2F7fa9%2Fimg%2Favatars%2Fava_0003-192.png","image_512":"https:\/\/secure.gravatar.com\/avatar\/3751438447930aa8569f0c9a2c421f2a.jpg?s=512&d=https%3A%2F%2Fslack.global.ssl.fastly.net%2F7fa9%2Fimg%2Favatars%2Fava_0003-512.png","fields":null},"is_admin":false,"is_owner":false,"is_primary_owner":false,"is_restricted":false,"is_ultra_restricted":false,"is_bot":false},{"id":"U0DMWCKHC","team_id":"T0DMJ48UE","name":"lumbini","deleted":false,"status":null,"color":"3c989f","real_name":"Lumbini Parnas","tz":"America\/Indiana\/Indianapolis","tz_label":"Eastern Standard Time","tz_offset":-18000,"profile":{"fields":{"Xf0DMJUBHQ":{"value":"lumbinineha","alt":""}},"skype":"lumbinineha","phone":"5084888301","last_name":"Parnas","first_name":"Lumbini","image_24":"https:\/\/avatars.slack-edge.com\/2015-11-06\/14074460151_ee8b43b224995f8c5131_24.jpg","image_32":"https:\/\/avatars.slack-edge.com\/2015-11-06\/14074460151_ee8b43b224995f8c5131_32.jpg","image_48":"https:\/\/avatars.slack-edge.com\/2015-11-06\/14074460151_ee8b43b224995f8c5131_48.jpg","image_72":"https:\/\/avatars.slack-edge.com\/2015-11-06\/14074460151_ee8b43b224995f8c5131_72.jpg","image_192":"https:\/\/avatars.slack-edge.com\/2015-11-06\/14074460151_ee8b43b224995f8c5131_192.jpg","image_512":"https:\/\/avatars.slack-edge.com\/2015-11-06\/14074460151_ee8b43b224995f8c5131_512.jpg","image_1024":"https:\/\/avatars.slack-edge.com\/2015-11-06\/14074460151_ee8b43b224995f8c5131_512.jpg","image_original":"https:\/\/avatars.slack-edge.com\/2015-11-06\/14074460151_ee8b43b224995f8c5131_original.jpg","real_name":"Lumbini Parnas","real_name_normalized":"Lumbini Parnas","email":"lparnas@wpi.edu"},"is_admin":false,"is_owner":false,"is_primary_owner":false,"is_restricted":false,"is_ultra_restricted":false,"is_bot":false},{"id":"U0DME3K37","team_id":"T0DMJ48UE","name":"mark","deleted":false,"status":null,"color":"9f69e7","real_name":"","tz":"America\/Indiana\/Indianapolis","tz_label":"Eastern Standard Time","tz_offset":-18000,"profile":{"real_name":"","real_name_normalized":"","email":"jatouma@wpi.edu","image_24":"https:\/\/secure.gravatar.com\/avatar\/88c0616adeccd3602e3e303e95be5958.jpg?s=24&d=https%3A%2F%2Fslack.global.ssl.fastly.net%2F66f9%2Fimg%2Favatars%2Fava_0014-24.png","image_32":"https:\/\/secure.gravatar.com\/avatar\/88c0616adeccd3602e3e303e95be5958.jpg?s=32&d=https%3A%2F%2Fslack.global.ssl.fastly.net%2F66f9%2Fimg%2Favatars%2Fava_0014-32.png","image_48":"https:\/\/secure.gravatar.com\/avatar\/88c0616adeccd3602e3e303e95be5958.jpg?s=48&d=https%3A%2F%2Fslack.global.ssl.fastly.net%2F66f9%2Fimg%2Favatars%2Fava_0014-48.png","image_72":"https:\/\/secure.gravatar.com\/avatar\/88c0616adeccd3602e3e303e95be5958.jpg?s=72&d=https%3A%2F%2Fslack.global.ssl.fastly.net%2F66f9%2Fimg%2Favatars%2Fava_0014-72.png","image_192":"https:\/\/secure.gravatar.com\/avatar\/88c0616adeccd3602e3e303e95be5958.jpg?s=192&d=https%3A%2F%2Fslack.global.ssl.fastly.net%2F7fa9%2Fimg%2Favatars%2Fava_0014-192.png","image_512":"https:\/\/secure.gravatar.com\/avatar\/88c0616adeccd3602e3e303e95be5958.jpg?s=512&d=https%3A%2F%2Fslack.global.ssl.fastly.net%2F7fa9%2Fimg%2Favatars%2Fava_0014-512.png","fields":null},"is_admin":true,"is_owner":true,"is_primary_owner":true,"is_restricted":false,"is_ultra_restricted":false,"is_bot":false},{"id":"U0DP3RJ3U","team_id":"T0DMJ48UE","name":"pwpeterson","deleted":false,"status":null,"color":"e96699","real_name":"","tz":"America\/Indiana\/Indianapolis","tz_label":"Eastern Standard Time","tz_offset":-18000,"profile":{"real_name":"","real_name_normalized":"","email":"pwpeterson@wpi.edu","image_24":"https:\/\/secure.gravatar.com\/avatar\/8fbd5a9c8414012c750b373e64f50f3b.jpg?s=24&d=https%3A%2F%2Fslack.global.ssl.fastly.net%2F66f9%2Fimg%2Favatars%2Fava_0026-24.png","image_32":"https:\/\/secure.gravatar.com\/avatar\/8fbd5a9c8414012c750b373e64f50f3b.jpg?s=32&d=https%3A%2F%2Fslack.global.ssl.fastly.net%2F66f9%2Fimg%2Favatars%2Fava_0026-32.png","image_48":"https:\/\/secure.gravatar.com\/avatar\/8fbd5a9c8414012c750b373e64f50f3b.jpg?s=48&d=https%3A%2F%2Fslack.global.ssl.fastly.net%2F272a%2Fimg%2Favatars%2Fava_0026-48.png","image_72":"https:\/\/secure.gravatar.com\/avatar\/8fbd5a9c8414012c750b373e64f50f3b.jpg?s=72&d=https%3A%2F%2Fslack.global.ssl.fastly.net%2F66f9%2Fimg%2Favatars%2Fava_0026-72.png","image_192":"https:\/\/secure.gravatar.com\/avatar\/8fbd5a9c8414012c750b373e64f50f3b.jpg?s=192&d=https%3A%2F%2Fslack.global.ssl.fastly.net%2F7fa9%2Fimg%2Favatars%2Fava_0026-192.png","image_512":"https:\/\/secure.gravatar.com\/avatar\/8fbd5a9c8414012c750b373e64f50f3b.jpg?s=512&d=https%3A%2F%2Fslack.global.ssl.fastly.net%2F7fa9%2Fimg%2Favatars%2Fava_0026-512.png","fields":null},"is_admin":false,"is_owner":false,"is_primary_owner":false,"is_restricted":false,"is_ultra_restricted":false,"is_bot":false},{"id":"U0DN53BC0","team_id":"T0DMJ48UE","name":"wsullivan","deleted":false,"status":null,"color":"674b1b","real_name":"","tz":"America\/Indiana\/Indianapolis","tz_label":"Eastern Standard Time","tz_offset":-18000,"profile":{"real_name":"","real_name_normalized":"","email":"wsullivan@wpi.edu","image_24":"https:\/\/secure.gravatar.com\/avatar\/48c054bba7966b775acf0bea2cfec8a2.jpg?s=24&d=https%3A%2F%2Fslack.global.ssl.fastly.net%2F66f9%2Fimg%2Favatars%2Fava_0008-24.png","image_32":"https:\/\/secure.gravatar.com\/avatar\/48c054bba7966b775acf0bea2cfec8a2.jpg?s=32&d=https%3A%2F%2Fslack.global.ssl.fastly.net%2F66f9%2Fimg%2Favatars%2Fava_0008-32.png","image_48":"https:\/\/secure.gravatar.com\/avatar\/48c054bba7966b775acf0bea2cfec8a2.jpg?s=48&d=https%3A%2F%2Fslack.global.ssl.fastly.net%2F66f9%2Fimg%2Favatars%2Fava_0008-48.png","image_72":"https:\/\/secure.gravatar.com\/avatar\/48c054bba7966b775acf0bea2cfec8a2.jpg?s=72&d=https%3A%2F%2Fslack.global.ssl.fastly.net%2F66f9%2Fimg%2Favatars%2Fava_0008-72.png","image_192":"https:\/\/secure.gravatar.com\/avatar\/48c054bba7966b775acf0bea2cfec8a2.jpg?s=192&d=https%3A%2F%2Fslack.global.ssl.fastly.net%2F7fa9%2Fimg%2Favatars%2Fava_0008-192.png","image_512":"https:\/\/secure.gravatar.com\/avatar\/48c054bba7966b775acf0bea2cfec8a2.jpg?s=512&d=https%3A%2F%2Fslack.global.ssl.fastly.net%2F7fa9%2Fimg%2Favatars%2Fava_0008-512.png","fields":null},"is_admin":false,"is_owner":false,"is_primary_owner":false,"is_restricted":false,"is_ultra_restricted":false,"is_bot":false},{"id":"USLACKBOT","team_id":"T0DMJ48UE","name":"slackbot","deleted":false,"status":null,"color":"757575","real_name":"slackbot","tz":null,"tz_label":"Pacific Standard Time","tz_offset":-28800,"profile":{"first_name":"slackbot","last_name":"","image_24":"https:\/\/slack.global.ssl.fastly.net\/66f9\/img\/slackbot_24.png","image_32":"https:\/\/slack.global.ssl.fastly.net\/66f9\/img\/slackbot_32.png","image_48":"https:\/\/slack.global.ssl.fastly.net\/66f9\/img\/slackbot_48.png","image_72":"https:\/\/slack.global.ssl.fastly.net\/66f9\/img\/slackbot_72.png","image_192":"https:\/\/slack.global.ssl.fastly.net\/66f9\/img\/slackbot_192.png","image_512":"https:\/\/slack.global.ssl.fastly.net\/7fa9\/img\/slackbot_512.png","real_name":"slackbot","real_name_normalized":"slackbot","email":null,"fields":null},"is_admin":false,"is_owner":false,"is_primary_owner":false,"is_restricted":false,"is_ultra_restricted":false,"is_bot":false}],"version_ts":1447280868,"min_version_ts":1446772063,"cache_version":"v11-mouse","cache_ts_version":"v1-cat","bots":[{"id":"B0DME3K8D","deleted":false,"name":"gdrive"},{"id":"B0DMTCW1H","deleted":true,"name":"github","icons":{"image_48":"https:\/\/slack.global.ssl.fastly.net\/5721\/plugins\/github\/assets\/bot_48.png"}},{"id":"B0DPSSM8C","deleted":true,"name":"github","icons":{"image_48":"https:\/\/slack.global.ssl.fastly.net\/5721\/plugins\/github\/assets\/bot_48.png"}}]};
	
//-->
</script>			
		
				<!-- output_js "core" -->
<script type="text/javascript" src="https://slack.global.ssl.fastly.net/d0231/js/rollup-core_required_libs.js" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://slack.global.ssl.fastly.net/c633/js/rollup-core_required_ts.js" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://slack.global.ssl.fastly.net/9da5/js/TS.web.js" crossorigin="anonymous"></script>

	<!-- output_js "core_web" -->
<script type="text/javascript" src="https://slack.global.ssl.fastly.net/72f5/js/rollup-core_web.js" crossorigin="anonymous"></script>

	<!-- output_js "secondary" -->
<script type="text/javascript" src="https://slack.global.ssl.fastly.net/d4c5/js/rollup-secondary_a_required.js" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://slack.global.ssl.fastly.net/f15e/js/rollup-secondary_b_required.js" crossorigin="anonymous"></script>

		<!-- output_js "regular" -->
<script type="text/javascript" src="https://slack.global.ssl.fastly.net/5070/js/TS.web.comments.js" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://slack.global.ssl.fastly.net/38e4/js/TS.web.file.js" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://slack.global.ssl.fastly.net/e26c/js/libs/codemirror.js" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://slack.global.ssl.fastly.net/9e78/js/codemirror_load.js" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://slack.global.ssl.fastly.net/c299/js/TS.storage_old.js" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://slack.global.ssl.fastly.net/6f1bd/js/TS.user_groups.js" crossorigin="anonymous"></script>
<script type="text/javascript" src="https://slack.global.ssl.fastly.net/31ae/js/TS.ui.admin_user_groups.js" crossorigin="anonymous"></script>

		<script type="text/javascript">
	<!--
		boot_data.page_needs_custom_emoji = true;
		
		boot_data.file = {"id":"F0EBF25JN","created":1447285380,"timestamp":1447285380,"name":"MainStage.java","title":"MainStage.java","mimetype":"text\/plain","filetype":"java","pretty_type":"Java","user":"U0DMWCKHC","editable":true,"size":4449,"mode":"snippet","is_external":false,"external_type":"","is_public":true,"public_url_shared":false,"display_as_bot":false,"username":"","url":"https:\/\/slack-files.com\/files-pub\/T0DMJ48UE-F0EBF25JN-438022abee\/mainstage.java","url_download":"https:\/\/slack-files.com\/files-pub\/T0DMJ48UE-F0EBF25JN-438022abee\/download\/mainstage.java","url_private":"https:\/\/files.slack.com\/files-pri\/T0DMJ48UE-F0EBF25JN\/mainstage.java","url_private_download":"https:\/\/files.slack.com\/files-pri\/T0DMJ48UE-F0EBF25JN\/download\/mainstage.java","permalink":"https:\/\/team-ocho.slack.com\/files\/lumbini\/F0EBF25JN\/mainstage.java","permalink_public":"https:\/\/slack-files.com\/T0DMJ48UE-F0EBF25JN-438022abee","edit_link":"https:\/\/team-ocho.slack.com\/files\/lumbini\/F0EBF25JN\/mainstage.java\/edit","preview":"\/**\r\n* Created by Lumbini on 11\/7\/2015.\r\n * *\/\r\n\r\nimport java.awt.*;\r\nimport javax.swing.*;\r\n\r\npublic class MainStage extends JFrame\r\n{\r\n    public static void main(String[] args)\r","preview_highlight":"\u003Cdiv class=\"CodeMirror cm-s-default CodeMirrorServer\"\u003E\n\u003Cdiv class=\"CodeMirror-code\"\u003E\n\u003Cdiv\u003E\u003Cpre\u003E\u003Cspan class=\"cm-comment\"\u003E\/**\u003C\/span\u003E\u003C\/pre\u003E\u003C\/div\u003E\n\u003Cdiv\u003E\u003Cpre\u003E\u003Cspan class=\"cm-comment\"\u003E* Created by Lumbini on 11\/7\/2015.\u003C\/span\u003E\u003C\/pre\u003E\u003C\/div\u003E\n\u003Cdiv\u003E\u003Cpre\u003E \u003Cspan class=\"cm-comment\"\u003E* *\/\u003C\/span\u003E\u003C\/pre\u003E\u003C\/div\u003E\n\u003Cdiv\u003E\u003Cpre\u003E&#8203;\u003C\/pre\u003E\u003C\/div\u003E\n\u003Cdiv\u003E\u003Cpre\u003E\u003Cspan class=\"cm-keyword\"\u003Eimport\u003C\/span\u003E \u003Cspan class=\"cm-variable\"\u003Ejava\u003C\/span\u003E.\u003Cspan class=\"cm-variable\"\u003Eawt\u003C\/span\u003E.\u003Cspan class=\"cm-operator\"\u003E*\u003C\/span\u003E;\u003C\/pre\u003E\u003C\/div\u003E\n\u003Cdiv\u003E\u003Cpre\u003E\u003Cspan class=\"cm-keyword\"\u003Eimport\u003C\/span\u003E \u003Cspan class=\"cm-variable\"\u003Ejavax\u003C\/span\u003E.\u003Cspan class=\"cm-variable\"\u003Eswing\u003C\/span\u003E.\u003Cspan class=\"cm-operator\"\u003E*\u003C\/span\u003E;\u003C\/pre\u003E\u003C\/div\u003E\n\u003Cdiv\u003E\u003Cpre\u003E&#8203;\u003C\/pre\u003E\u003C\/div\u003E\n\u003Cdiv\u003E\u003Cpre\u003E\u003Cspan class=\"cm-keyword\"\u003Epublic\u003C\/span\u003E \u003Cspan class=\"cm-keyword\"\u003Eclass\u003C\/span\u003E \u003Cspan class=\"cm-variable\"\u003EMainStage\u003C\/span\u003E \u003Cspan class=\"cm-keyword\"\u003Eextends\u003C\/span\u003E \u003Cspan class=\"cm-variable\"\u003EJFrame\u003C\/span\u003E\u003C\/pre\u003E\u003C\/div\u003E\n\u003Cdiv\u003E\u003Cpre\u003E{\u003C\/pre\u003E\u003C\/div\u003E\n\u003Cdiv\u003E\u003Cpre\u003E    \u003Cspan class=\"cm-keyword\"\u003Epublic\u003C\/span\u003E \u003Cspan class=\"cm-keyword\"\u003Estatic\u003C\/span\u003E \u003Cspan class=\"cm-keyword\"\u003Evoid\u003C\/span\u003E \u003Cspan class=\"cm-variable\"\u003Emain\u003C\/span\u003E(\u003Cspan class=\"cm-variable\"\u003EString\u003C\/span\u003E[] \u003Cspan class=\"cm-variable\"\u003Eargs\u003C\/span\u003E)\u003C\/pre\u003E\u003C\/div\u003E\n\u003C\/div\u003E\n\u003C\/div\u003E\n","lines":35,"lines_more":25,"channels":["C0DMJ494N"],"groups":[],"ims":[],"comments_count":0};
		boot_data.file.comments = [];

		

		var g_editor;

		$(function(){

			var wrap_long_lines = !!TS.model.code_wrap_long_lines;

			g_editor = CodeMirror(function(elt){
				var content = document.getElementById("file_contents");
				content.parentNode.replaceChild(elt, content);
			}, {
				value: $('#file_contents').text(),
				lineNumbers: true,
				matchBrackets: true,
				indentUnit: 4,
				indentWithTabs: true,
				enterMode: "keep",
				tabMode: "shift",
				viewportMargin: Infinity,
				readOnly: true,
				lineWrapping: wrap_long_lines
			});

			$('#file_preview_wrap_cb').bind('change', function(e) {
				TS.model.code_wrap_long_lines = $(this).prop('checked');
				g_editor.setOption('lineWrapping', TS.model.code_wrap_long_lines);
			})

			$('#file_preview_wrap_cb').prop('checked', wrap_long_lines);

			CodeMirror.switchSlackMode(g_editor, "java");
		});

		
		$('#file_comment').css('overflow', 'hidden').autogrow();
	//-->
	</script>

			<script type="text/javascript">TS.boot(boot_data);</script>
	<!-- slack-www304 / 2015-11-11 15:43:13 / v07a742e8dec652f8a2a70b99dbc6ea540ee2c68a -->
<style>.color_9f69e7:not(.nuc) {color:#9F69E7;}.color_4bbe2e:not(.nuc) {color:#4BBE2E;}.color_e7392d:not(.nuc) {color:#E7392D;}.color_3c989f:not(.nuc) {color:#3C989F;}.color_674b1b:not(.nuc) {color:#674B1B;}.color_e96699:not(.nuc) {color:#E96699;}.color_e0a729:not(.nuc) {color:#E0A729;}.color_684b6c:not(.nuc) {color:#684B6C;}.color_5b89d5:not(.nuc) {color:#5B89D5;}.color_2b6836:not(.nuc) {color:#2B6836;}.color_99a949:not(.nuc) {color:#99A949;}.color_df3dc0:not(.nuc) {color:#DF3DC0;}.color_4cc091:not(.nuc) {color:#4CC091;}.color_9b3b45:not(.nuc) {color:#9B3B45;}.color_d58247:not(.nuc) {color:#D58247;}.color_bb86b7:not(.nuc) {color:#BB86B7;}.color_5a4592:not(.nuc) {color:#5A4592;}.color_db3150:not(.nuc) {color:#DB3150;}.color_235e5b:not(.nuc) {color:#235E5B;}.color_9e3997:not(.nuc) {color:#9E3997;}.color_53b759:not(.nuc) {color:#53B759;}.color_c386df:not(.nuc) {color:#C386DF;}.color_385a86:not(.nuc) {color:#385A86;}.color_a63024:not(.nuc) {color:#A63024;}.color_5870dd:not(.nuc) {color:#5870DD;}.color_ea2977:not(.nuc) {color:#EA2977;}.color_50a0cf:not(.nuc) {color:#50A0CF;}.color_d55aef:not(.nuc) {color:#D55AEF;}.color_d1707d:not(.nuc) {color:#D1707D;}.color_43761b:not(.nuc) {color:#43761B;}.color_e06b56:not(.nuc) {color:#E06B56;}.color_8f4a2b:not(.nuc) {color:#8F4A2B;}.color_902d59:not(.nuc) {color:#902D59;}.color_de5f24:not(.nuc) {color:#DE5F24;}.color_a2a5dc:not(.nuc) {color:#A2A5DC;}.color_827327:not(.nuc) {color:#827327;}.color_3c8c69:not(.nuc) {color:#3C8C69;}.color_8d4b84:not(.nuc) {color:#8D4B84;}.color_84b22f:not(.nuc) {color:#84B22F;}.color_4ec0d6:not(.nuc) {color:#4EC0D6;}.color_e23f99:not(.nuc) {color:#E23F99;}.color_e475df:not(.nuc) {color:#E475DF;}.color_619a4f:not(.nuc) {color:#619A4F;}.color_a72f79:not(.nuc) {color:#A72F79;}.color_7d414c:not(.nuc) {color:#7D414C;}.color_aba727:not(.nuc) {color:#ABA727;}.color_965d1b:not(.nuc) {color:#965D1B;}.color_4d5e26:not(.nuc) {color:#4D5E26;}.color_dd8527:not(.nuc) {color:#DD8527;}.color_bd9336:not(.nuc) {color:#BD9336;}.color_e85d72:not(.nuc) {color:#E85D72;}.color_dc7dbb:not(.nuc) {color:#DC7DBB;}.color_bc3663:not(.nuc) {color:#BC3663;}.color_9d8eee:not(.nuc) {color:#9D8EEE;}.color_8469bc:not(.nuc) {color:#8469BC;}.color_73769d:not(.nuc) {color:#73769D;}.color_b14cbc:not(.nuc) {color:#B14CBC;}</style>
</body>
</html>