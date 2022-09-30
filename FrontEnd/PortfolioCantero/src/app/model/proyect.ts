export class Proyect {
    id!: number;
    nombre: string;
    fecha: string;
    descripcion: string;
    link: string;

    constructor(nombre: string, fecha: string, descripcion: string, link: string){
        this.nombre = nombre;
        this.fecha = fecha;
        this.descripcion = descripcion;
        this.link = link;
    }

}
