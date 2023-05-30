/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Com.unique;

import javax.jws.WebService;
import javax.jws.WebMethod;
import javax.jws.WebParam;

/**
 *
 * @author 390
 */
@WebService(serviceName = "LCM")
public class LCM {

    /**
     * Web service operation
     */
    @WebMethod(operationName = "getNumber")
    public int getNumber(@WebParam(name = "Num1") int Num1, @WebParam(name = "Num2") int Num2) {
        //TODO write your implementation code here:
        int lcm=(Num1>Num2)? Num1:Num2 ;
        while(true)
        {
            if(lcm%Num1==0 && lcm% Num2==0)
            {
                return lcm;
            }
            ++lcm;
        }
    }

    
}
