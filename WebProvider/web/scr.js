function load1()
{
$(function(){
    $.getJSON('c1.json', function(data) {
        
                $('#k1').append('<p>'+data.one +'<br>'+data.kol+'<br>'+ data.two[0].p +'<br>'+ data.two[0].v +'<br>'+
                 data.two[0].s+'<br>' +data.w+ '</p>');
            
    });
});
}

function load2()
{
$(function(){
    $.getJSON('c2.json', function(data) {
        
                $('#k2').append('<p>'+data.one +'<br>'+data.kol+'<br>'+ data.two[0].p +'<br>'+ data.two[0].v +'<br>'+
                 data.two[0].s+'<br>' +data.w+ '</p>');
            
    });
});
}
function load3()
{
$(function(){
    $.getJSON('c3.json', function(data) {
        
                $('#k3').append('<p>'+data.one +'<br>'+data.kol+'<br>'+ data.two[0].p +'<br>'+ data.two[0].v +'<br>'+
                 data.two[0].s+'<br>' +data.w+ '</p>');
            
    });
});
}
var bigsize = "300"; //Размер большой картинки
var smallsize = "174"; //Размер маленькой картинки
function changeSizeImage(im) {
  if(im.height == bigsize) im.height = smallsize;
  else im.height = bigsize;
  if(im.width == bigsize) im.width = smallsize;
  else im.width = bigsize;
}
