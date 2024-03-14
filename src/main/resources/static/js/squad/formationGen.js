class FormationGen {

  constructor(obj) {
    this.file = obj;
  }

  drawPositionDiv(arr){
    let mainDiv = document.createElement("div");
    mainDiv.className = "pos-outer-div";
    for (let i = 0; i < arr.length; i++) {

      let newPlayer = document.createElement('div');
      newPlayer.className = "player";

      let newPlayerNum = document.createElement('div');
      newPlayerNum.className = "player-num";
      newPlayerNum.innerHTML = arr[i].formation_place;
      newPlayer.appendChild(newPlayerNum);
      mainDiv.appendChild(newPlayer);
    }

    return mainDiv;
  }

  generateFormationDiv(){

    let divStr = document.createElement("div");
    let GK = [];
    let DF = [];
    let MF = [];
    let FW = [];

    for (let i = 0; i < this.file.players.length; i++) {
      if (this.file.players[i].type == "Goalkeeper") {
        GK.push(this.file.players[i]);
      }
      else if (this.file.players[i].type == "Defender") {
        DF.push(this.file.players[i]);
      }
      else if (this.file.players[i].type == "Midfielder") {
        MF.push(this.file.players[i]);
      }
      else if (this.file.players[i].type == "Forward") {
        FW.push(this.file.players[i]);
      }
    }

    //generate divs
    if (GK.length > 0){
      divStr.appendChild(this.drawPositionDiv(GK));
    }
    if (DF.length > 0){
      divStr.appendChild(this.drawPositionDiv(DF));
    }
    if (MF.length > 0){
      divStr.appendChild(this.drawPositionDiv(MF));
    }
    if (FW.length > 0){
      divStr.appendChild(this.drawPositionDiv(FW));
    }
    return divStr;

  }
}