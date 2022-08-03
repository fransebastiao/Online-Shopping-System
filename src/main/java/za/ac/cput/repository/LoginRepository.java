package za.ac.cput.repository;

import za.ac.cput.domain.Login;

import java.util.ArrayList;

import java.util.List;



    public class LoginRepository implements IRepository<Login, String>{



        private static LoginRepository repo = null;

        private List<Login> loginList = null;



        private LoginRepository(){

            loginList = new ArrayList<Login>();

        }



        public static LoginRepository getRepo(){

            if(repo == null)

                repo = new LoginRepository();

            return repo;

        }



        public List<Login> getAll() {

            return loginList;

        }



        @Override
        public Login create(Login login) {

            boolean myOperation = loginList.add(login);

            if (!myOperation)

                return null;

            return login;

        }



        @Override

        public Login read(String loginId) {

            for (Login login : loginList)

                if (login.getLoginid().equals(loginId))

                    return login;

            return null;

        }



        @Override

        public Login update(Login login) {

            Login oldLogin = read(login.getLoginid());

            if (oldLogin != null){

                loginList.remove(oldLogin);

                loginList.add(login);

                return login;

            }

            return null;

        }



        @Override

        public boolean delete(String loginId) {

            Login deleteLogin = read(loginId);

            if (deleteLogin == null){

                throw new IllegalArgumentException("Failed to delete, there is nothing to delete");

            }

            loginList.remove(loginId);

            return true;

        }

    }

