package chapter15;

interface Payable {
}

class Employee implements Payable{}

class Hourly extends Employee implements Payable{}
