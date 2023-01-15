export class Wette{

    constructor() {}

    id: number | undefined;
    spielID: number | undefined;
    benutzerID: number | undefined;
    einsatz: number | undefined;
    quote: number | undefined;
    auswahl: Auswahl | undefined;


}

export enum Auswahl{
        HEIM = "HEIM",
        AUSWAERTS = "AUSWAERTS",
        UNENTSCHIEDEN = "UNENTSCHIEDEN"
}