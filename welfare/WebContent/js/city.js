var CITYS = {
    "北京": ["北京"],
    "上海": ["上海"],
    "天津": ["天津", "塘沽"],
    "重庆": ["重庆", "涪陵", "江津", "巫山"],
    "河北": ["石家庄", "张家口", "承德", "秦皇岛", "唐山", "廊坊", "保定", "沧州", "衡水", "邢台", "邯郸", "张北", "蔚县", "丰宁", "围场", "怀来", "遵化", "青龙", "坝县", "乐亭", "饶阳", "黄骅", "南宫"],
    "山西": ["太原", "大同", "朔州", "阳泉", "长治", "晋城", "忻州", "晋中", "临汾", "运城", "吕梁", "右玉", "河曲", "五台山", "五寨", "兴县", "原平", "离石", "榆社", "隰县", "介休", "候马", "阳城"],
    "内蒙古": ["呼和浩特", "包头", "乌海", "赤峰", "通辽", "呼伦贝尔", "鄂尔多斯", "乌兰察布", "巴彦淖尔", "兴安盟", "锡林郭勒盟", "阿拉善盟", "额尔古纳右旗", "图里河", "满州里", "海拉尔", "小二沟", "新巴尔虎右旗", "新巴尔虎左旗", "博克图", "扎兰屯", "科前旗阿尔山", "索轮", "乌兰浩特", "东乌珠穆沁旗", "额济纳旗", "拐子湖", "巴音毛道", "阿拉善右旗", "二连浩特", "那仁宝力格", "满都拉", "阿巴嘎旗", "苏尼特左旗", "海力素", "朱日和", "乌拉特中旗", "百灵庙", "四子王旗", "化德", "集宁", "吉兰太", "临河", "鄂托克旗", "东胜", "伊金霍洛旗", "阿拉善左旗", "西乌珠穆沁旗", "扎鲁特旗", "巴林左旗", "锡林浩特", "林西", "开鲁", "多伦", "翁牛特旗", "宝国图"],
    "辽宁": ["沈阳", "朝阳", "阜新", "铁岭", "抚顺", "本溪", "辽阳", "鞍山", "丹东", "大连", "营口", "盘锦", "锦州", "葫芦岛", "彰武", "开原", "清原", "叶柏寿", "新民", "黑山", "章党", "桓仁", "绥中", "兴城", "岫岩", "宽甸", "瓦房店", "庄河"],
    "吉林": ["长春", "白城", "松原", "吉林", "四平", "辽源", "通化", "白山", "延吉", "乾安", "前郭尔罗斯", "通榆", "长岭", "三岔河", "双辽", "蛟河", "敦化", "汪清", "梅河口", "桦甸", "靖宇", "东岗", "松江", "临江", "集安", "长白"],
    "黑龙江": ["哈尔滨", "齐齐哈尔", "黑河", "大庆", "伊春", "鹤岗", "佳木斯", "双鸭山", "七台河", "鸡西", "牡丹江", "绥化", "大兴安岭", "漠河", "塔河", "新林", "呼玛", "嫩江", "孙吴", "北安", "克山", "富裕", "海伦", "明水", "富锦", "泰来", "安达", "铁力", "依兰", "宝清", "肇州", "通河", "尚志", "虎林", "绥芬河"],
    "江苏": ["南京", "徐州", "连云港", "宿迁", "淮安", "盐城", "扬州", "泰州", "南通", "镇江", "常州", "无锡", "苏州", "赣榆", "盱眙", "淮阴", "射阳", "高邮", "东台", "吕泗", "溧阳", "吴县东山"],
    "浙江": ["杭州", "湖州", "嘉兴", "舟山", "宁波", "绍兴", "衢州", "金华", "台州", "温州", "丽水", "平湖", "慈溪", "嵊泗", "定海", "嵊县", "鄞县", "龙泉", "洪家", "玉环"],
    "安徽": ["合肥", "宿州", "淮北", "阜阳", "亳州", "蚌埠", "淮南", "滁州", "马鞍山", "芜湖", "铜陵", "安庆", "黄山", "六安", "巢湖", "池州", "宣城", "砀山", "宿县", "寿县", "霍山", "桐城", "芜湖县", "宁国", "屯溪"],
    "福建": ["福州", "南平", "三明", "莆田", "泉州", "厦门", "漳州", "龙岩", "宁德", "邵武", "武夷山市", "浦城", "建瓯", "福鼎", "泰宁", "长汀", "上杭", "永安", "屏南", "平潭", "崇武", "东山"],
    "江西": ["南昌", "九江", "景德镇", "鹰潭", "新余", "萍乡", "赣州", "上饶", "抚州", "宜春", "吉安", "修水", "宁冈", "遂川", "庐山", "波阳", "樟树", "贵溪", "玉山", "南城", "广昌", "寻乌"],
    "山东": ["济南", "聊城", "德州", "东营", "淄博", "潍坊", "烟台", "威海", "青岛", "日照", "临沂", "枣庄", "济宁", "泰安", "莱芜", "滨州", "菏泽", "惠民县", "羊角沟", "长岛", "龙口", "成山头", "朝城", "泰山", "沂源", "莱阳", "海阳", "石岛", "兖州", "莒县"],
    "河南": ["郑州", "三门峡", "洛阳", "焦作", "新乡", "鹤壁", "安阳", "濮阳", "开封", "商丘", "许昌", "漯河", "平顶山", "南阳", "信阳", "周口", "驻马店", "济源", "卢氏", "孟津", "栾川", "西峡", "宝丰", "西华", "固始"],
    "湖北": ["武汉", "十堰", "襄樊", "荆门", "孝感", "黄冈", "鄂州", "黄石", "咸宁", "荆州", "宜昌", "随州", "仙桃", "天门", "潜江", "神农架", "恩施", "郧西", "房县", "老河口", "枣阳", "巴东", "钟祥", "广水", "麻城", "五峰", "来风", "嘉鱼", "英山"],
    "湖南": ["长沙", "张家界", "常德", "益阳", "岳阳", "株洲", "湘潭", "衡阳", "郴州", "永州", "邵阳", "怀化", "娄底", "吉首", "桑植", "石门", "南县", "沅陵", "安化", "沅江", "平江", "芷江", "双峰", "南岳", "通道", "武冈", "零陵", "常宁", "道县"],
    "广东": ["广州", "清远", "韶关", "河源", "梅州", "潮州", "汕头", "揭阳", "汕尾", "惠州", "东莞", "深圳", "珠海", "中山", "江门", "佛山", "肇庆", "云浮", "阳江", "茂名", "湛江", "南雄", "连县", "佛冈", "连平", "广宁", "增城", "五华", "惠来", "南澳", "信宜", "罗定", "台山", "电白", "徐闻"],
    "广西": ["南宁", "桂林", "柳州", "梧州", "贵港", "玉林", "钦州", "北海", "防城港", "崇左", "百色", "河池", "来宾", "贺州", "融安", "凤山", "都安", "蒙山", "那坡", "靖西", "平果", "桂平", "龙州", "灵山", "东兴", "涠洲岛"],
    "海南": ["海口", "三亚", "文昌", "琼海", "万宁", "东方", "澄迈", "定安", "儋县", "琼中", "陵水", "西沙", "昌江", "乐东", "白沙", "临高"],
    "四川": ["成都", "广元", "绵阳", "德阳", "南充", "广安", "遂宁", "内江", "乐山", "自贡", "泸州", "宜宾", "攀枝花", "巴中", "达川", "资阳", "眉山", "雅安", "阿坝", "甘孜", "西昌", "石渠", "若尔盖", "德格", "色达", "道孚", "马尔康", "红原", "小金", "松潘", "都江堰", "平武", "巴塘", "新龙", "理塘", "稻城", "康定", "峨眉山", "木里", "九龙", "越西", "昭觉", "雷波", "盐源", "会理", "万源", "阆中", "奉节", "梁平", "万县市", "叙永", "酉阳"],
    "贵州": ["贵阳", "六盘水", "遵义", "安顺", "毕节", "铜仁", "凯里", "都匀", "兴义", "威宁", "盘县", "桐梓", "习水", "湄潭", "思南", "黔西", "三穗", "兴仁", "望谟", "罗甸", "独山", "榕江"],
    "云南": ["昆明", "曲靖", "玉溪", "保山", "昭通", "丽江", "思茅", "临沧", "德宏", "怒江", "迪庆", "大理", "楚雄", "红河", "文山州", "德钦", "贡山", "中甸", "维西", "华坪", "会泽", "腾冲", "元谋", "沾益", "瑞丽", "景东", "泸西", "耿马", "澜沧", "景洪", "元江", "勐腊", "江城", "蒙自", "屏边", "广南", "勐海"],
    "西藏": ["拉萨", "那曲", "昌都", "林芝", "山南", "日喀则", "阿里", "狮泉河", "改则", "班戈", "安多", "普兰", "申扎", "当雄", "拉孜", "尼木", "泽当", "聂拉木", "定日", "江孜", "错那", "隆子", "帕里", "索县", "丁青", "嘉黎", "洛隆", "波密", "左贡", "察隅"],
    "陕西": ["西安", "延安", "铜川", "渭南", "咸阳", "宝鸡", "汉中", "榆林", "安康", "商洛", "定边", "吴旗", "横山", "绥德", "长武", "洛川", "武功", "华山", "略阳", "佛坪", "镇安", "石泉"],
    "甘肃": ["兰州", "嘉峪关", "金昌", "白银", "天水", "武威", "酒泉", "张掖", "庆阳", "安西", "陇南", "临夏", "甘南", "马鬃山", "敦煌", "玉门镇", "金塔", "高台", "山丹", "永昌", "民勤", "景泰", "靖远", "榆中", "临洮", "环县", "平凉", "西峰镇", "玛曲", "夏河合作", "岷县", "定西"],
    "青海": ["西宁", "海东", "海北", "海南", "黄南", "果洛", "玉树", "海西", "茫崖", "冷湖", "祁连", "大柴旦", "德令哈", "刚察", "门源", "格尔木", "都兰", "共和县", "贵德", "民和", "兴海", "同德", "同仁", "杂多", "曲麻莱", "玛多", "清水河", "达日", "河南", "久治", "囊谦", "班玛"],
    "宁夏": ["银川", "石嘴山", "吴忠", "固原", "中卫", "惠农", "陶乐", "中宁", "盐池", "海源", "同心", "西吉"],
    "新疆": ["乌鲁木齐", "克拉玛依", "石河子", "阿拉尔", "喀什", "阿克苏", "和田", "吐鲁番", "哈密", "克孜勒", "博尔塔拉", "昌吉", "库尔勒", "伊犁", "塔城", "阿勒泰", "哈巴河", "吉木乃", "福海", "富蕴", "和布克赛尔", "青河", "阿拉山口", "托里", "北塔山", "温泉", "精河", "乌苏", "蔡家湖", "奇台", "昭苏", "巴仑台", "达板城", "七角井", "库米什", "巴音布鲁克", "焉耆", "拜城", "轮台", "库车", "吐尔尕特", "乌恰", "阿合奇", "巴楚", "柯坪", "铁干里克", "若羌", "塔什库尔干", "莎车", "皮山", "民丰", "且末", "于田", "巴里坤", "伊吾", "伊宁"],
    "香港": ["香港"],
    "澳门": ["澳门"],
    "台湾": ["台北", "台中", "高雄"]
};
var CITYNUM = {
    '1': ['北京'],
    '2': ['上海'],
    '3': ['天津'],
    '4': ['塘沽'],
    '5': ['重庆'],
    '6': ['涪陵'],
    '7': ['江津'],
    '8': ['巫山'],
    '9': ['石家庄'],
    '10': ['张家口'],
    '11': ['承德'],
    '12': ['秦皇岛'],
    '13': ['唐山'],
    '14': ['廊坊'],
    '15': ['保定'],
    '16': ['沧州'],
    '17': ['衡水'],
    '18': ['邢台'],
    '19': ['邯郸'],
    '20': ['张北'],
    '21': ['蔚县'],
    '22': ['丰宁'],
    '23': ['坝县'],
    '24': ['围场'],
    '25': ['怀来'],
    '26': ['遵化'],
    '27': ['青龙'],
    '28': ['坝县'],
    '29': ['乐亭'],
    '30': ['饶阳'],
    '31': ['黄骅'],
    '32': ['南宫'],
    '33': ['太原'],
    '34': ['大同'],
    '35': ['朔州'],
    '36': ['阳泉'],
    '37': ['长治'],
    '38': ['晋城'],
    '39': ['忻州'],
    '40': ['晋中'],
    '41': ['临汾'],
    '42': ['运城'],
    '43': ['吕梁'],
    '44': ['右玉'],
    '45': ['河曲'],
    '46': ['五台山'],
    '47': ['五寨'],
    '48': ['兴县'],
    '49': ['原平'],
    '50': ['离石'],
    '51': ['榆社'],
    '52': ['隰县'],
    '53': ['介休'],
    '54': ['候马'],
    '55': ['阳城'],
    '56': ['呼和浩特'],
    '57': ['包头'],
    '58': ['乌海'],
    '59': ['赤峰'],
    '60': ['通辽'],
    '61': ['呼伦贝尔'],
    '62': ['鄂尔多斯'],
    '63': ['乌兰察布'],
    '64': ['巴彦淖尔'],
    '65': ['兴安盟'],
    '66': ['锡林郭勒盟'],
    '67': ['阿拉善盟'],
    '68': ['额尔古纳右旗'],
    '69': ['图里河'],
    '70': ['满州里'],
    '71': ['海拉尔'],
    '72': ['小二沟'],
    '73': ['新巴尔虎右旗'],
    '74': ['新巴尔虎左旗'],
    '75': ['博克图'],
    '76': ['扎兰屯'],
    '77': ['科前旗阿尔山'],
    '78': ['索轮'],
    '79': ['乌兰浩特'],
    '80': ['东乌珠穆沁旗'],
    '81': ['额济纳旗'],
    '82': ['拐子湖'],
    '83': ['巴音毛道'],
    '84': ['阿拉善右旗'],
    '85': ['二连浩特'],
    '86': ['那仁宝力格'],
    '87': ['满都拉'],
    '88': ['阿巴嘎旗'],
    '89': ['苏尼特左旗'],
    '90': ['海力素'],
    '91': ['朱日和'],
    '92': ['乌拉特中旗'],
    '93': ['百灵庙'],
    '94': ['四子王旗'],
    '95': ['化德'],
    '96': ['集宁'],
    '97': ['吉兰太'],
    '98': ['临河'],
    '99': ['鄂托克旗'],
    '100': ['东胜'],
    '101': ['伊金霍洛旗'],
    '102': ['阿拉善左旗'],
    '103': ['西乌珠穆沁旗'],
    '104': ['扎鲁特旗'],
    '105': ['巴林左旗'],
    '106': ['锡林浩特'],
    '107': ['林西'],
    '108': ['开鲁'],
    '109': ['多伦'],
    '110': ['翁牛特旗'],
    '111': ['宝国图'],
    '112': ['沈阳'],
    '113': ['朝阳'],
    '114': ['阜新'],
    '115': ['铁岭'],
    '116': ['抚顺'],
    '117': ['本溪'],
    '118': ['辽阳'],
    '119': ['鞍山'],
    '120': ['丹东'],
    '121': ['大连'],
    '122': ['营口'],
    '123': ['盘锦'],
    '124': ['锦州'],
    '125': ['葫芦岛'],
    '126': ['彰武'],
    '127': ['开原'],
    '128': ['清原'],
    '129': ['叶柏寿'],
    '130': ['新民'],
    '131': ['黑山'],
    '132': ['章党'],
    '133': ['桓仁'],
    '134': ['绥中'],
    '135': ['兴城'],
    '136': ['岫岩'],
    '137': ['宽甸'],
    '138': ['瓦房店'],
    '139': ['庄河'],
    '140': ['长春'],
    '141': ['白城'],
    '142': ['松原'],
    '143': ['吉林'],
    '144': ['四平'],
    '145': ['辽源'],
    '146': ['通化'],
    '147': ['白山'],
    '148': ['延吉'],
    '149': ['乾安'],
    '150': ['前郭尔罗斯'],
    '151': ['通榆'],
    '152': ['长岭'],
    '153': ['三岔河'],
    '154': ['双辽'],
    '155': ['蛟河'],
    '156': ['敦化'],
    '157': ['汪清'],
    '158': ['梅河口'],
    '159': ['桦甸'],
    '160': ['靖宇'],
    '161': ['东岗'],
    '162': ['松江'],
    '163': ['临江'],
    '164': ['集安'],
    '165': ['长白'],
    '166': ['哈尔滨'],
    '167': ['齐齐哈尔'],
    '168': ['黑河'],
    '169': ['大庆'],
    '170': ['伊春'],
    '171': ['鹤岗'],
    '172': ['佳木斯'],
    '173': ['双鸭山'],
    '174': ['七台河'],
    '175': ['鸡西'],
    '176': ['牡丹江'],
    '177': ['绥化'],
    '178': ['大兴安岭'],
    '179': ['漠河'],
    '180': ['塔河'],
    '181': ['新林'],
    '182': ['呼玛'],
    '183': ['嫩江'],
    '184': ['孙吴'],
    '185': ['北安'],
    '186': ['克山'],
    '187': ['富裕'],
    '188': ['海伦'],
    '189': ['明水'],
    '190': ['富锦'],
    '191': ['泰来'],
    '192': ['安达'],
    '193': ['铁力'],
    '194': ['依兰'],
    '195': ['宝清'],
    '196': ['肇州'],
    '197': ['通河'],
    '198': ['尚志'],
    '199': ['虎林'],
    '200': ['绥芬河'],
    '201': ['南京'],
    '202': ['徐州'],
    '203': ['连云港'],
    '204': ['宿迁'],
    '205': ['淮安'],
    '206': ['盐城'],
    '207': ['扬州'],
    '208': ['泰州'],
    '209': ['南通'],
    '210': ['镇江'],
    '211': ['常州'],
    '212': ['无锡'],
    '213': ['苏州'],
    '214': ['赣榆'],
    '215': ['盱眙'],
    '216': ['淮阴'],
    '217': ['射阳'],
    '218': ['高邮'],
    '219': ['东台'],
    '220': ['吕泗'],
    '221': ['溧阳'],
    '222': ['吴县东山'],
    '223': ['杭州'],
    '224': ['湖州'],
    '225': ['嘉兴'],
    '226': ['舟山'],
    '227': ['宁波'],
    '228': ['绍兴'],
    '229': ['衢州'],
    '230': ['金华'],
    '231': ['台州'],
    '232': ['温州'],
    '233': ['丽水'],
    '234': ['平湖'],
    '235': ['慈溪'],
    '236': ['嵊泗'],
    '237': ['定海'],
    '238': ['嵊县'],
    '239': ['鄞县'],
    '240': ['龙泉'],
    '241': ['洪家'],
    '242': ['玉环'],
    '243': ['合肥'],
    '244': ['宿州'],
    '245': ['淮北'],
    '246': ['阜阳'],
    '247': ['亳州'],
    '248': ['蚌埠'],
    '249': ['淮南'],
    '250': ['滁州'],
    '251': ['马鞍山'],
    '252': ['芜湖'],
    '253': ['铜陵'],
    '254': ['安庆'],
    '255': ['黄山'],
    '256': ['六安'],
    '257': ['巢湖'],
    '258': ['池州'],
    '259': ['宣城'],
    '260': ['砀山'],
    '261': ['宿县'],
    '262': ['寿县'],
    '263': ['霍山'],
    '264': ['桐城'],
    '265': ['芜湖县'],
    '266': ['宁国'],
    '267': ['屯溪'],
    '268': ['福州'],
    '269': ['南平'],
    '270': ['三明'],
    '271': ['莆田'],
    '272': ['泉州'],
    '273': ['厦门'],
    '274': ['漳州'],
    '275': ['龙岩'],
    '276': ['宁德'],
    '277': ['邵武'],
    '278': ['武夷山市'],
    '279': ['浦城'],
    '280': ['建瓯'],
    '281': ['福鼎'],
    '282': ['泰宁'],
    '283': ['长汀'],
    '284': ['上杭'],
    '285': ['永安'],
    '286': ['屏南'],
    '287': ['平潭'],
    '288': ['崇武'],
    '289': ['东山'],
    '290': ['南昌'],
    '291': ['九江'],
    '292': ['景德镇'],
    '293': ['鹰潭'],
    '294': ['新余'],
    '295': ['萍乡'],
    '296': ['赣州'],
    '297': ['上饶'],
    '298': ['抚州'],
    '299': ['宜春'],
    '300': ['吉安'],
    '301': ['修水'],
    '302': ['宁冈'],
    '303': ['遂川'],
    '304': ['庐山'],
    '305': ['波阳'],
    '306': ['樟树'],
    '307': ['贵溪'],
    '308': ['玉山'],
    '309': ['南城'],
    '310': ['广昌'],
    '311': ['寻乌'],
    '312': ['济南'],
    '313': ['聊城'],
    '314': ['德州'],
    '315': ['东营'],
    '316': ['淄博'],
    '317': ['潍坊'],
    '318': ['烟台'],
    '319': ['威海'],
    '320': ['青岛'],
    '321': ['日照'],
    '322': ['临沂'],
    '323': ['枣庄'],
    '324': ['济宁'],
    '325': ['泰安'],
    '326': ['莱芜'],
    '327': ['滨州'],
    '328': ['菏泽'],
    '329': ['惠民县'],
    '330': ['羊角沟'],
    '331': ['长岛'],
    '332': ['龙口'],
    '333': ['成山头'],
    '334': ['朝城'],
    '335': ['泰山'],
    '336': ['沂源'],
    '337': ['莱阳'],
    '338': ['海阳'],
    '339': ['石岛'],
    '340': ['兖州'],
    '341': ['莒县'],
    '342': ['郑州'],
    '343': ['三门峡'],
    '344': ['洛阳'],
    '345': ['焦作'],
    '346': ['新乡'],
    '347': ['鹤壁'],
    '348': ['安阳'],
    '349': ['濮阳'],
    '350': ['开封'],
    '351': ['商丘'],
    '352': ['许昌'],
    '353': ['漯河'],
    '354': ['平顶山'],
    '355': ['南阳'],
    '356': ['信阳'],
    '357': ['周口'],
    '358': ['驻马店'],
    '359': ['济源'],
    '360': ['卢氏'],
    '361': ['孟津'],
    '362': ['栾川'],
    '363': ['西峡'],
    '364': ['宝丰'],
    '365': ['西华'],
    '366': ['固始'],
    '367': ['武汉'],
    '368': ['十堰'],
    '369': ['襄樊'],
    '370': ['荆门'],
    '371': ['孝感'],
    '372': ['黄冈'],
    '373': ['鄂州'],
    '374': ['黄石'],
    '375': ['咸宁'],
    '376': ['荆州'],
    '377': ['宜昌'],
    '378': ['随州'],
    '379': ['仙桃'],
    '380': ['天门'],
    '381': ['潜江'],
    '382': ['神农架'],
    '383': ['恩施'],
    '384': ['郧西'],
    '385': ['房县'],
    '386': ['老河口'],
    '387': ['枣阳'],
    '388': ['巴东'],
    '389': ['钟祥'],
    '390': ['广水'],
    '391': ['麻城'],
    '392': ['五峰'],
    '393': ['来风'],
    '394': ['嘉鱼'],
    '395': ['英山'],
    '396': ['长沙'],
    '397': ['张家界'],
    '398': ['常德'],
    '399': ['益阳'],
    '400': ['岳阳'],
    '401': ['株洲'],
    '402': ['湘潭'],
    '403': ['衡阳'],
    '404': ['郴州'],
    '405': ['永州'],
    '406': ['邵阳'],
    '407': ['怀化'],
    '408': ['娄底'],
    '409': ['吉首'],
    '410': ['桑植'],
    '411': ['石门'],
    '412': ['南县'],
    '413': ['沅陵'],
    '414': ['安化'],
    '415': ['沅江'],
    '416': ['平江'],
    '417': ['芷江'],
    '418': ['双峰'],
    '419': ['南岳'],
    '420': ['通道'],
    '421': ['武冈'],
    '422': ['零陵'],
    '423': ['常宁'],
    '424': ['道县'],
    '425': ['广州'],
    '426': ['清远'],
    '427': ['韶关'],
    '428': ['河源'],
    '429': ['梅州'],
    '430': ['潮州'],
    '431': ['汕头'],
    '432': ['揭阳'],
    '433': ['汕尾'],
    '434': ['惠州'],
    '435': ['东莞'],
    '436': ['深圳'],
    '437': ['珠海'],
    '438': ['中山'],
    '439': ['江门'],
    '440': ['佛山'],
    '441': ['肇庆'],
    '442': ['云浮'],
    '443': ['阳江'],
    '444': ['茂名'],
    '445': ['湛江'],
    '446': ['南雄'],
    '447': ['连县'],
    '448': ['佛冈'],
    '449': ['连平'],
    '450': ['广宁'],
    '451': ['增城'],
    '452': ['五华'],
    '453': ['惠来'],
    '454': ['南澳'],
    '455': ['信宜'],
    '456': ['罗定'],
    '457': ['台山'],
    '458': ['电白'],
    '459': ['徐闻'],
    '460': ['南宁'],
    '461': ['桂林'],
    '462': ['柳州'],
    '463': ['梧州'],
    '464': ['贵港'],
    '465': ['玉林'],
    '466': ['钦州'],
    '467': ['北海'],
    '468': ['防城港'],
    '469': ['崇左'],
    '470': ['百色'],
    '471': ['河池'],
    '472': ['来宾'],
    '473': ['贺州'],
    '474': ['融安'],
    '475': ['凤山'],
    '476': ['都安'],
    '477': ['蒙山'],
    '478': ['那坡'],
    '479': ['靖西'],
    '480': ['平果'],
    '481': ['桂平'],
    '482': ['龙州'],
    '483': ['灵山'],
    '484': ['东兴'],
    '485': ['涠洲岛'],
    '486': ['海口'],
    '487': ['三亚'],
    '488': ['文昌'],
    '489': ['琼海'],
    '490': ['万宁'],
    '491': ['东方'],
    '492': ['澄迈'],
    '493': ['定安'],
    '494': ['儋县'],
    '495': ['琼中'],
    '496': ['陵水'],
    '497': ['西沙'],
    '498': ['昌江'],
    '499': ['乐东'],
    '500': ['白沙'],
    '501': ['临高'],
    '502': ['成都'],
    '503': ['广元'],
    '504': ['绵阳'],
    '505': ['德阳'],
    '506': ['南充'],
    '507': ['广安'],
    '508': ['遂宁'],
    '509': ['内江'],
    '510': ['乐山'],
    '511': ['自贡'],
    '512': ['泸州'],
    '513': ['宜宾'],
    '514': ['攀枝花'],
    '515': ['巴中'],
    '516': ['达川'],
    '517': ['资阳'],
    '518': ['眉山'],
    '519': ['雅安'],
    '520': ['阿坝'],
    '521': ['甘孜'],
    '522': ['西昌'],
    '523': ['石渠'],
    '524': ['若尔盖'],
    '525': ['德格'],
    '526': ['色达'],
    '527': ['道孚'],
    '528': ['马尔康'],
    '529': ['红原'],
    '530': ['小金'],
    '531': ['松潘'],
    '532': ['都江堰'],
    '533': ['平武'],
    '534': ['巴塘'],
    '535': ['新龙'],
    '536': ['理塘'],
    '537': ['稻城'],
    '538': ['康定'],
    '539': ['峨眉山'],
    '540': ['木里'],
    '541': ['九龙'],
    '542': ['越西'],
    '543': ['昭觉'],
    '544': ['雷波'],
    '545': ['盐源'],
    '546': ['会理'],
    '547': ['万源'],
    '548': ['阆中'],
    '549': ['奉节'],
    '550': ['梁平'],
    '551': ['万县市'],
    '552': ['叙永'],
    '553': ['酉阳'],
    '554': ['贵阳'],
    '555': ['六盘水'],
    '556': ['遵义'],
    '557': ['安顺'],
    '558': ['毕节'],
    '559': ['铜仁'],
    '560': ['凯里'],
    '561': ['都匀'],
    '562': ['兴义'],
    '563': ['威宁'],
    '564': ['盘县'],
    '565': ['桐梓'],
    '566': ['习水'],
    '567': ['湄潭'],
    '568': ['思南'],
    '569': ['黔西'],
    '570': ['三穗'],
    '571': ['兴仁'],
    '572': ['望谟'],
    '573': ['罗甸'],
    '574': ['独山'],
    '575': ['榕江'],
    '576': ['云南'],
    '577': ['昆明'],
    '578': ['曲靖'],
    '579': ['玉溪'],
    '580': ['保山'],
    '581': ['昭通'],
    '582': ['丽江'],
    '583': ['思茅'],
    '584': ['临沧'],
    '585': ['德宏'],
    '586': ['怒江'],
    '587': ['迪庆'],
    '588': ['大理'],
    '589': ['楚雄'],
    '590': ['红河'],
    '591': ['文山州'],
    '592': ['德钦'],
    '593': ['贡山'],
    '594': ['中甸'],
    '595': ['维西'],
    '596': ['华坪'],
    '597': ['会泽'],
    '598': ['腾冲'],
    '599': ['元谋'],
    '600': ['沾益'],
    '601': ['瑞丽'],
    '602': ['景东'],
    '603': ['泸西'],
    '604': ['耿马'],
    '605': ['澜沧'],
    '606': ['景洪'],
    '607': ['元江'],
    '608': ['勐腊'],
    '609': ['江城'],
    '610': ['蒙自'],
    '611': ['屏边'],
    '612': ['广南'],
    '613': ['勐海'],
    '614': ['拉萨'],
    '615': ['那曲'],
    '616': ['昌都'],
    '617': ['林芝'],
    '618': ['山南'],
    '619': ['日喀则'],
    '620': ['阿里'],
    '621': ['狮泉河'],
    '622': ['改则'],
    '623': ['班戈'],
    '624': ['安多'],
    '625': ['普兰'],
    '626': ['申扎'],
    '627': ['当雄'],
    '628': ['拉孜'],
    '629': ['尼木'],
    '630': ['泽当'],
    '631': ['聂拉木'],
    '632': ['定日'],
    '633': ['江孜'],
    '634': ['错那'],
    '635': ['隆子'],
    '636': ['帕里'],
    '637': ['索县'],
    '638': ['丁青'],
    '639': ['嘉黎'],
    '640': ['洛隆'],
    '641': ['波密'],
    '642': ['左贡'],
    '643': ['察隅'],
    '644': ['西安'],
    '645': ['延安'],
    '646': ['铜川'],
    '647': ['渭南'],
    '648': ['咸阳'],
    '649': ['宝鸡'],
    '650': ['汉中'],
    '651': ['榆林'],
    '652': ['安康'],
    '653': ['商洛'],
    '654': ['定边'],
    '655': ['吴旗'],
    '656': ['横山'],
    '657': ['绥德'],
    '658': ['长武'],
    '659': ['洛川'],
    '660': ['武功'],
    '661': ['华山'],
    '662': ['略阳'],
    '663': ['佛坪'],
    '664': ['镇安'],
    '665': ['石泉'],
    '666': ['兰州'],
    '667': ['嘉峪关'],
    '668': ['金昌'],
    '669': ['白银'],
    '670': ['天水'],
    '671': ['武威'],
    '672': ['酒泉'],
    '673': ['张掖'],
    '674': ['庆阳'],
    '675': ['安西'],
    '676': ['陇南'],
    '677': ['临夏'],
    '678': ['甘南'],
    '679': ['马鬃山'],
    '680': ['敦煌'],
    '681': ['玉门镇'],
    '682': ['金塔'],
    '683': ['高台'],
    '684': ['山丹'],
    '685': ['永昌'],
    '686': ['民勤'],
    '687': ['景泰'],
    '688': ['靖远'],
    '689': ['榆中'],
    '690': ['临洮'],
    '691': ['环县'],
    '692': ['平凉'],
    '693': ['西峰镇'],
    '694': ['玛曲'],
    '695': ['夏河合作'],
    '696': ['岷县'],
    '697': ['定西'],
    '698': ['西宁'],
    '699': ['海东'],
    '700': ['海北'],
    '701': ['海南'],
    '702': ['黄南'],
    '703': ['果洛'],
    '704': ['玉树'],
    '705': ['海西'],
    '706': ['茫崖'],
    '707': ['冷湖'],
    '708': ['祁连'],
    '709': ['大柴旦'],
    '710': ['德令哈'],
    '711': ['刚察'],
    '712': ['门源'],
    '713': ['格尔木'],
    '714': ['都兰'],
    '715': ['共和县'],
    '716': ['贵德'],
    '717': ['民和'],
    '718': ['兴海'],
    '719': ['同德'],
    '720': ['同仁'],
    '721': ['杂多'],
    '722': ['曲麻莱'],
    '723': ['玛多'],
    '724': ['清水河'],
    '725': ['达日'],
    '726': ['河南'],
    '727': ['久治'],
    '728': ['囊谦'],
    '729': ['班玛'],
    '730': ['银川'],
    '731': ['石嘴山'],
    '732': ['吴忠'],
    '733': ['固原'],
    '734': ['中卫'],
    '735': ['惠农'],
    '736': ['陶乐'],
    '737': ['中宁'],
    '738': ['盐池'],
    '739': ['海源'],
    '740': ['同心'],
    '741': ['西吉'],
    '742': ['乌鲁木齐'],
    '743': ['克拉玛依'],
    '744': ['石河子'],
    '745': ['阿拉尔'],
    '746': ['喀什'],
    '747': ['阿克苏'],
    '748': ['和田'],
    '749': ['吐鲁番'],
    '750': ['哈密'],
    '751': ['克孜勒'],
    '752': ['博尔塔拉'],
    '753': ['昌吉'],
    '754': ['库尔勒'],
    '755': ['伊犁'],
    '756': ['塔城'],
    '757': ['阿勒泰'],
    '758': ['哈巴河'],
    '759': ['吉木乃'],
    '760': ['福海'],
    '761': ['富蕴'],
    '762': ['和布克赛尔'],
    '763': ['青河'],
    '764': ['阿拉山口'],
    '765': ['托里'],
    '766': ['北塔山'],
    '767': ['温泉'],
    '768': ['精河'],
    '769': ['乌苏'],
    '770': ['蔡家湖'],
    '771': ['奇台'],
    '772': ['昭苏'],
    '773': ['巴仑台'],
    '774': ['达板城'],
    '775': ['七角井'],
    '776': ['库米什'],
    '777': ['巴音布鲁克'],
    '778': ['焉耆'],
    '779': ['拜城'],
    '780': ['轮台'],
    '781': ['库车'],
    '782': ['吐尔尕特'],
    '783': ['乌恰'],
    '784': ['阿合奇'],
    '785': ['巴楚'],
    '786': ['柯坪'],
    '787': ['铁干里克'],
    '788': ['若羌'],
    '789': ['塔什库尔干'],
    '790': ['莎车'],
    '791': ['香港'],
    '792': ['澳门'],
    '793': ['台北'],
    '794': ['台中'],
    '795': ['高雄'],
};

$(function () {
    //初始化 所有的省的数据
    $.each(CITYS, function (key, value) {
        var $option = $("<option></option>");
        $option.text(key); //获取当前省的名字
        $("#leaves-province").append($option);
    });

    //当省的数据发生改变的时候执行 加载市的数据
    $("#leaves-province").on("change", function () {
        //拿到当前省的名字
        var pro = $("#leaves-province option:selected").text();

        //清空原有的city数据
        $("#leaves-city").empty()
        //根据省名，拿到所有的城市，然后根据城市创建option添加到cityselect中
        // each里面的参数不加双引号
        $.each(CITYS[pro], function (i, value) {
            for (var key in CITYNUM) {
                if (CITYNUM[key] == value) {
                    var citynumber = key;
                    break;
                }
            }
            $("#leaves-city").append('<option' + ' value="' + value + '">' + value + '</option>');
        });
    });

    //上来后初始化一下城市的数据
    $("#leaves-province").triggerHandler('change');
});