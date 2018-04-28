/**
 * Created by Kirk liu on 2017/6/22.
 */
module.exports = function (time) {
    return {
        time: time,
        format: function (str) {
            var add0 = function (m) {
                return m < 10 ? '0' + m : m
            };
            var time = new Date(this.time);
            var y = time.getYear() + 1900;
            var m = time.getMonth() + 1;
            var d = time.getDate();
            var h = time.getHours();
            var mm = time.getMinutes();
            var ss = time.getSeconds();
            str = str.trim();

            var dateStr = str.indexOf(' ') != -1 ? str.substring(0, str.indexOf(' ')) : str;
            var YYYYStr = str.indexOf('Y') != -1 ? dateStr.substring(0, 4) : '';
            var YYYYStr_ = str.indexOf('Y') != -1 ? dateStr.substring(4, 5) : '';
            var MMStr = str.indexOf('M') != -1 ? dateStr.substring(str.indexOf('M'), str.indexOf('M') + 2) : '';
            var MMStr_ = str.indexOf('M') != -1 ? dateStr.substring(str.indexOf('M') + 2, str.indexOf('M') + 3) : '';
            var DDStr = str.indexOf('D') != -1 ? dateStr.substring(str.indexOf('D'), str.indexOf('D') + 2) : '';
            var DDStr_ = str.indexOf('D') != -1 ? dateStr.substring(str.indexOf('D') + 2, str.indexOf('D') + 3) : '';

            var timeStr = str.indexOf(' ') != -1 ? str.substring(str.indexOf(' ') + 1, str.length) : str;
            var HHStr = str.indexOf('H') != -1 ? timeStr.substring(0, 2) : '';
            var HHStr_ = str.indexOf('H') != -1 ? timeStr.substring(2, 3) : '';
            var mmStr = str.indexOf('mm') != -1 ? timeStr.substring(3, 5) : '';
            var mmStr_ = str.indexOf('mm') != -1 ? timeStr.substring(5, 6) : '';
            var ssStr = str.indexOf('ss') != -1 ? timeStr.substring(6, 8) : '';
            return ((YYYYStr && add0(y)) + YYYYStr_ + (MMStr && add0(m)) + MMStr_ + (DDStr && add0(d)) + DDStr_ + ' ' + (HHStr && add0(h)) + HHStr_ + (mmStr && add0(mm)) + mmStr_ + (ssStr && add0(ss))).trim();
        }
    }
}