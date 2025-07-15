// this class must be map to entity class in login in login-micro service add login table in database
export class Login {
    constructor(
    public emailid:string,     // instance variable consider as private
    public password:string,
    public typeofuser:string,
    public changePassword?:string    
    ){}
}
