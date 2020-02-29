
function delDataByUrl(url, obj = null) {
    $.ajax({
        url: url,
        method: "get",
        dataType: "json",
        success:function(msg) {
            if(msg == "1"){
                alert("删除成功");
                if(obj){
                    $(obj).parents("tr").remove();
                }
            }else{
                alert("删除失败");
            }
        },
        error:function(params) {
            alert("系统错误");
        }
    });
}