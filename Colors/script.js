console.log("Work");

var requestURL = 'https://jsonplaceholder.typicode.com/photos';
var request = new XMLHttpRequest();
var data;

request.onreadystatechange = function() {
    if (this.readyState == 4 && this.status == 200) {
        data = JSON.parse(this.responseText);
        fill();
    }
};
request.open('GET', requestURL);
request.send();

var index=0;
var linenumber=4;

function fill(){
    for(var i=0; i<linenumber; i++){
        addline();
    }
}

function addline() {
    var line=document.createElement("div");
    line.setAttribute("class", "line");
    document.getElementById('block').appendChild(line);

    var wid=window.innerWidth;
    var x=parseInt(wid/300);
    var y=wid-x*300;
    var space= parseInt(y/(x+1)-x);

    for(var i=0; i<x; i++){
        var card=document.createElement("div");
        card.setAttribute("class", "card");
        card.style.marginLeft = space+"px";
        line.appendChild(card);
        addcard(card);
        index++;
    }
}

function addcard(card){
    var title = document.createElement("div");
    var link=document.createElement("div");
    var pics=document.createElement("div");

    title.setAttribute("class", "title");
    link.setAttribute("class", "link");
    pics.setAttribute("class", "pics");

    title.innerHTML="<p>"+"AlbumId: "+data[index].albumId+"<br>Id: "+data[index].id+"<br>Title: "+data[index].title+"</p>";
    link.innerHTML="<a href="+data[index].url+">"+data[index].url+"</a>";
    pics.innerHTML="<img src='"+data[index].thumbnailUrl+"' width='100' height='100'>";

    card.appendChild(pics);
    card.appendChild(title);
    card.appendChild(link);
}

function addmore(){
    linenumber=3;
    fill();
}
