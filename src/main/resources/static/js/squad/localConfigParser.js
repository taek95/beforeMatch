class LocalConfigParser {

  constructor(json) {
    this.file = json;
  }

  getLocalConfigData() {
    return new Promise((resolve, reject) =>
    {
      fetch('./res/'+this.file +'.json')
      .then((resp) => resp.json())
      .then((data) => {
        resolve(data);
        return data;
      })
      .catch(() => {
        alert("error loading data");
      })
    })
  }
}