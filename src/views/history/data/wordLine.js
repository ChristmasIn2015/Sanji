// 时间：0 东亚 1 中东 2 欧洲 3 非洲 4 美洲 5 大洋洲 * 中国
const worldTime = new Map();
worldTime.set("", ["东亚", "中东", "欧洲", "非洲", "美洲", "大洋洲", "中国"]);
worldTime.set("1949", ["中华人民共和国成立", "", "", "", "", "", ""]);
worldTime.set("1946", ["", "", "北大西洋公约：马歇尔计划", "", "冷战：华盛顿/莫斯科", "", ""]);
worldTime.set("1900", [
    "辛亥革命/侵华战争<br>印度独立<br>日本经济腾飞",
    "以色列：犹太复国",
    "第一次世界大战<br>第二次世界大战<br>沙俄社会主义",
    "",
    "大繁荣：大萧条",
    "",
    "",
]);
worldTime.set("1700", [
    "太平天国运动<br>鸦片战争<br>甲午中日战争<br>明治维新",
    "",
    "三角贸易<br>天花病毒<br>瓜分非洲：第一次世界大战<br>毫无征兆的崛起：英国工业革命<br>法国大革命<br>民族独立风潮",
    "",
    "美国独立<br>淘金热<br>南北战争",
    "",
    "",
]);
worldTime.set("1050", [
    "阿拉伯入侵 & 闭关锁国<br>成吉思汗：丰功伟绩",
    "土耳其攻占拜占庭：十字军东征<br>奥斯曼帝国兴起",
    "葡西/荷英法：地理大发现<br>非欧贸易<br>英法百年战争<br>文艺复兴",
    "",
    "",
    "",
    "",
]);
worldTime.set("450", [
    "隋唐丝绸之路<br>日本大化改新",
    "伊斯兰诞生<br>阿拉伯帝国",
    "地中海贸易<br>法兰克帝国<br>西罗马灭亡<br>拜占庭帝国（东罗马）",
    "",
    "",
    "",
    "",
]);
worldTime.set("-800", ["", "波斯帝国", "希腊/亚历山大东征<br>罗马城市", "", "", "", ""]);
worldTime.set("-3500", ["黄河长江", "底格里斯/幼发拉底河流", "群山聚集", "尼罗河流", "", "", ""]);

export default worldTime;