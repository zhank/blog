$(function () {
    var E = window.wangEditor
    var editor = new E('#editor') // 两个参数也可以传入 elem 对象，class 选择器
// editor.customConfig.uploadImgShowBase64 = true // 使用 base64 保存图片
// 配置服务器端地址
    editor.customConfig.uploadImgServer = '/img/uploadImg';
// 隐藏“网络图片”tab
    editor.customConfig.showLinkImg = false
// 关闭粘贴内容中的样式
    editor.customConfig.pasteFilterStyle = false
// 将图片大小限制为 3M
    editor.customConfig.uploadImgMaxSize = 3 * 1024 * 1024;
// 自定义上传参数
    editor.customConfig.uploadFileName = 'file';
    editor.customConfig.uploadImgHooks = {
        // 如果服务器端返回的不是 {errno:0, data: [...]} 这种格式，可使用该配置
        // （但是，服务器端返回的必须是一个 JSON 格式字符串！！！否则会报错）
        customInsert: function(insertImg, result, editor) {
            // 图片上传并返回结果，自定义插入图片的事件（而不是编辑器自动插入图片！！！）
            // insertImg 是插入图片的函数，editor 是编辑器对象，result 是服务器端返回的结果
            // 举例：假如上传图片成功后，服务器端返回的是 {url:'....'} 这种格式，即可这样插入图片：
            var url = result.url;
            insertImg(url)
            // result 必须是一个 JSON 格式字符串！！！否则报错
        }
    };

//自定义emoji 表情（微信）
    editor.customConfig.emotions = [{
        title: '😁',
        type: 'emoji',
        content: '☀ ☁ ☔ ⛄ ⚡ 🌀 🌁 🌂 🌃 🌄 🌅 🌆 🌇 🌈 ❄ ⛅ 🌉 🌊 🌋 🌌 🌏 🌑 🌔 🌓 🌙 🌕 🌛 🌟 🌠 🕐 🕑 🕒 🕓 🕔 🕕 🕖 🕗 🕘 🕙 🕚 🕛 ⌚ ⌛ ⏰ ⏳ ♈ ♉ ♊ ♋ ♌ ♍ ♎ ♏ ♐ ♑ ♒ ♓ ⛎ 🍀 🌷 🌱 🍁 🌸 🌹 🍂 🍃 🌺 🌻 🌴 🌵 🌾 🌽 🍄 🌰 🌼 🌿 🍒 🍌 🍎 🍊 🍓 🍉 🍅 🍆 🍈 🍍 🍇 🍑 🍏 👀 👂 👃 👄 👅 💄 💅 💆 💇 💈 👤 👦 👧 👨 👩 👪 👫 👮 👯 👰 👱 👲 👳 👴 👵 👶 👷 👸 👹 👺 👻 👼 👽 👾 👿 💀 💁 💂 💃 🐌 🐍 🐎 🐔 🐗 🐫 🐘 🐨 🐒 🐑 🐙 🐚 🐛 🐜 🐝 🐞 🐠 🐡 🐢 🐤 🐥 🐦 🐣 🐧 🐩 🐟 🐬 🐭 🐯 🐱 🐳 🐴 🐵 🐶 🐷 🐻 🐹 🐺 🐮 🐰 🐸 🐾 🐲 🐼 🐽 😠 😩 😲 😞 😵 😰 😒 😍 😤 😜 😝 😋 😘 😚 😷 😳 😃 😅 😆 😁 😂 😊 ☺ 😄 😢 😭 😨 😣 😡 😌 😖 😔 😱 😪 😏 😓 😥 😫 😉 😺 😸 😹 😽 😻 😿 😾 😼 🙀 🙅 🙆 🙇 🙈 🙊 🙉 🙋 🙌 🙍 🙎 🙏 🏠 🏡 🏢 🏣 🏥 🏦 🏧 🏨 🏩 🏪 🏫 ⛪ ⛲ 🏬 🏯 🏰 🏭 ⚓ 🏮 🗻 🗼 🗽 🗾 🗿 👞 👟 👠 👡 👢 👣 👓 👕 👖 👑 👔 👒 👗 👘 👙 👚 👛 👜 👝 💰 💱 💹 💲 💳 💴 💵 💸 🔥 🔦 🔧 🔨 🔩 🔪 🔫 🔮 🔯 🔰 🔱 💉 💊 🅰 🅱 🆎 🅾 🎀 🎁 🎂 🎄 🎅 🎌 🎆 🎈 🎉 🎍 🎎 🎓 🎒 🎏 🎇 🎐 🎃 🎊 🎋 🎑 📟 ☎ 📞 📱 📲 📝 📠 ✉ 📨 📩 📪 📫 📮 📰 📢 📣 📡 📤 📥 📦 📧 🔠 🔡 🔢 🔣 🔤 ✒ 💺 💻 ✏ 📎 💼 💽 💾 💿 📀 ✂ 📍 📃 📄 📅 📁 📂 📓 📖 📔 📕 📗 📘 📙 📚 📛 📜 📋 📆 📊 📈 📉 📇 📌 📒 📏 📐 📑 🎽 ⚾ ⛳ 🎾 ⚽ 🎿 🏀 🏁 🏂 🏃 🏄 🏆 🏈 🏊 🚃 🚇 Ⓜ 🚄 🚅 🚗 🚙 🚌 🚏 🚢 ✈ ⛵ 🚉 🚀 🚤 🚕 🚚 🚒 🚑 🚓 ⛽ 🅿 🚥 🚧 🚨 ♨ ⛺ 🎠 🎡 🎢 🎣 🎤 🎥 🎦 🎧 🎨 🎩 🎪 🎫 🎬 🎭 🎮 🀄 🎯 🎰 🎱 🎲 🎳 🎴 🃏 🎵 🎶 🎷 🎸 🎹 🎺 🎻 🎼 〽 📷 📹 📺 📻 📼 💋 💌 💍 💎 💏 💐 💑 💒 🔞 © ® ™ ℹ 🔟 📶 📳 📴 🍔 🍙 🍰 🍜 🍞 🍳 🍦 🍟 🍡 🍘 🍚 🍝 🍛 🍢 🍣 🍱 🍲 🍧 🍖 🍥 🍠 🍕 🍗 🍨 🍩 🍪 🍫 🍬 🍭 🍮 🍯 🍤 🍴 ☕ 🍸 🍺 🍵 🍶 🍷 🍻 🍹 ↗ ↘ ↖ ↙ ⤴ ⤵ ↔ ↕ ⬆ ⬇ ➡ ⬅ ▶ ◀ ⏩ ⏪ ⏫ ⏬ 🔺 🔻 🔼 🔽 ⭕ ❌ ❎ ❗ ⁉ ‼ ❓ ❔ ❕ 〰 ➰ - ❤ 💓 💔 💕 💖 💗 💘 💙 💚 💛 💜 💝 💞 💟 ♥ ♠ ♦ ♣ 🚬 🚭 ♿ 🚩 ⚠ ⛔ ♻ 🚲 🚶 🚹 🚺 🛀 🚻 🚽 🚾 🚼 🚪 🚫 ✔ 🆑 🆒 🆓 🆔 🆕 🆖 🆗 🆘 🆙 🆚 🈁 🈂 🈲 🈳 🈴 🈵 🈶 🈚 🈷 🈸 🈹 🈯 🈺 ㊙ ㊗ 🉐 🉑 ➕ ➖ ✖ ➗ 💠 💡 💢 💣 💤 💥 💦 💧 💨 💩 💪 💫 💬 ✨ ✴ ✳ ⚪ ⚫ 🔴 🔵 🔲 🔳 ⭐ ⬜ ⬛ ▫ ▪ ◽ ◾ ◻ ◼ 🔶 🔷 🔸 🔹 ❇ 💮 💯 ↩ ↪ 🔃 🔊 🔋 🔌 🔍 🔎 🔒 🔓 🔏 🔐 🔑 🔔 ☑ 🔘 🔖 🔗 🔙 🔚 🔛 🔜 🔝 ✅ ✊ ✋ ✌ 👊 👍 ☝ 👆 👇 👈 👉 👋 👏 👌 👎 👐'.split(/\s/)
    }];
//自定义颜色
    editor.customConfig.colors = ['#000000', '#eeece0', '#1c487f', '#4d80bf', '#c24f4a', '#8baa4a', '#7b5ba1', '#46acc8', '#f9963b', '#ffffff', '#ff84b8', '#f44336', '#e91e63', '#9c27b0', '#3f51b5', '#2196f3', '#03a9f4', '#00bcd4', '#009688', '#4caf50', '#cddc39', '#ffeb3b', '#ffc107', '#ff9800', '#ff5722', '#795548', '#9e9e9e', '#607d8b'];

// 必须放到有关于编辑器设置前面
    editor.create();

    $('#txtTitle').keyup(
        function() {
            var count = $(this).val().length;           $('.max-length-change').html(count);
        }   );

    $("#btnPublish").click(function() {
        var articleTitle = $("#txtTitle").val();
        var articleContent = $("#editor .w-e-text").html();
        if(articleTitle == "") {
            alert_error("标题不能为空！");
            return;
        }
        if(articleContent == "") {
            alert_error("内容不能为空！");
            return;
        }
        $.ajax({
            type: "POST",
            dataType: "json",
            url: '/article/publishArticle',
            contentType: "application/json;charset=utf-8",
            data: JSON.stringify({"articleTitle" : articleTitle, "articleContent" : articleContent}),
            async:true,
            success: function(result) {
                if (result.code == 200) {
                    alert_success(result.msg);
                    location.reload();
                }
            }
        });

    });

});
