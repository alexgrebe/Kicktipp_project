export class Benutzer {


  constructor(
    public vorname: string,
    public nachname: string,
    public email: string,
    public passwort: string,
    public profilepicturedata: string,
    public role: string,
    public geburtsdatum: string,
  ) {
  }
}
