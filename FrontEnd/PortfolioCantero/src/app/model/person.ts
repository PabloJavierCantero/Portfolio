export class Person {

    id!: number;
    fullname: string;
    imgPerfil: string;
    posicion: string;
    ubicacion: string;
    contacto: string;
    interes: string;
    acercade: string;

    constructor(fullname: string, imgPerfil: string, posicion: string, ubicacion: string, contacto: string, interes: string, acercade: string){
        this.fullname = fullname;
        this.imgPerfil = imgPerfil;
        this.posicion = posicion;
        this.ubicacion = ubicacion;
        this.contacto = contacto;
        this.interes = interes;
        this.acercade = acercade;
    }
}
