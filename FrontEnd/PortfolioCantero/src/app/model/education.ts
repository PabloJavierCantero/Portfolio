export class Education {

    id!: number;
    nombre: string;
    descripcion: string;
    fecha: string;
    titulo: string;

    constructor(nombre: string, descripcion: string, fecha: string, titulo: string){
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.titulo = titulo;

    }
}
