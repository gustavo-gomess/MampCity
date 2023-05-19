package model;


    public class Funcionario {
        private String clt;
        private String cargo;
        private String setor;
        private String expediente;
        private double salario;

        public Funcionario(String clt, String cargo, String setor, String expediente, double salario) {
            this.clt = clt;
            this.cargo = cargo;
            this.setor = setor;
            this.expediente = expediente;
            this.salario = salario;
        }


        public String getClt() {
            return clt;
        }

        public void setClt(String clt) {
            this.clt = clt;
        }

        public String getCargo() {
            return cargo;
        }

        public void setCargo(String cargo) {
            this.cargo = cargo;
        }

        public String getSetor() {
            return setor;
        }

        public void setSetor(String setor) {
            this.setor = setor;
        }

        public String getExpediente() {
            return expediente;
        }

        public void setExpediente(String expediente) {
            this.expediente = expediente;
        }

        public double getSalario() {
            return salario;
        }

        public void setSalario(double salario) {
            this.salario = salario;
        }
    }






