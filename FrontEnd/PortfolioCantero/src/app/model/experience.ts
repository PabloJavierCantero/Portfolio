export class Experience {

    id!: number;
    nombre: string;
    descripcion: string;
    fecha: string;
    puesto: string;

    constructor(nombre: string, descripcion: string, fecha: string, puesto: string){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.puesto = puesto;
    }
}
