function check() {
  if(document.getElementById('433').checked) {
    move433();
  }

  if(document.getElementById('442').checked) {
    move442();
  }

  if(document.getElementById('343').checked) {
    move343();
  }
};

function move433() {
  span3 = document.querySelectorAll(".player-one, .player-two, .player-three, .player-four");
    span4 = document.querySelectorAll(".player-five, .player-six, .player-seven, .player-eight, .player-nine, .player-ten");

    for (var i = 0, len = span3.length; i < len; i++) {
      span3[i].style.setProperty("grid-row", "span 3");
    }

    for (var i = 0, len = span4.length; i < len; i++) {
      span4[i].style.setProperty("grid-row", "span 4");
    }
}

function move442() {
  span3 = document.querySelectorAll(".player-one, .player-two, .player-three, .player-four, .player-five, .player-six, .player-seven, .player-eight");
    span6 = document.querySelectorAll(".player-nine, .player-ten");

    for (var i = 0, len = span3.length; i < len; i++) {
      span3[i].style.setProperty("grid-row", "span 3");
    }

    for (var i = 0, len = span6.length; i < len; i++) {
      span6[i].style.setProperty("grid-row", "span 6");
    }
}

function move343() {
  span3 = document.querySelectorAll(".player-four, .player-five, .player-six, .player-seven");
    span4 = document.querySelectorAll(".player-one, .player-two, .player-three, .player-eight, .player-nine, .player-ten");

    for (var i = 0, len = span3.length; i < len; i++) {
      span3[i].style.setProperty("grid-row", "span 3");
    }

    for (var i = 0, len = span4.length; i < len; i++) {
      span4[i].style.setProperty("grid-row", "span 4");
    }
}