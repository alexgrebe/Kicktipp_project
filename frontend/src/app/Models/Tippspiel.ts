export class Tippspiel {

    constructor( 
        public name: string,
        public privat: boolean,
        public ligaId: number | null,
        public Siegergewichtung: number,
        public Tordiffgewichtung: number,
        public Ergebnissgewichtung: number,
        public passwort: string,
         ) {}
}