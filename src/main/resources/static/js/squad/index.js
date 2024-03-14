class Index {

  constructor() {

  }

  init(){
    const configInstance = new LocalConfigParser("match-lineup");
    configInstance.getLocalConfigData().then((data) => this.callBackForConfig(data));
  }

  callBackForConfig(payload){
    const formationClassInstance = new FormationGen(payload);
    //console.log(formationClassInstance.generateFormationDiv());
    let mainComponent = document.getElementById("main-container");
    mainComponent.appendChild(formationClassInstance.generateFormationDiv());

    let introText = document.getElementById("into-text");
    let teamNameComponent = document.getElementById("team-name");
    if (payload.team != null){
      teamNameComponent.innerHTML = payload.team;
      introText.style.display ='block';
    }
  }
}

const indexInstance = new Index();
indexInstance.init();