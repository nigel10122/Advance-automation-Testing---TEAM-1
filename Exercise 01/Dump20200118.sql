-- MySQL dump 10.13  Distrib 8.0.18, for Win64 (x86_64)
--
-- Host: localhost    Database: company_management
-- ------------------------------------------------------
-- Server version	5.7.28-log

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `company`
--

DROP TABLE IF EXISTS `company`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `company` (
  `idcompany` varchar(16) NOT NULL,
  `company_name` varchar(45) NOT NULL,
  `phone` varchar(16) DEFAULT NULL,
  `email` varchar(45) NOT NULL,
  `date_ins` date NOT NULL,
  PRIMARY KEY (`idcompany`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `company`
--

LOCK TABLES `company` WRITE;
/*!40000 ALTER TABLE `company` DISABLE KEYS */;
INSERT INTO `company` VALUES ('000000','The Whibble','1234567890','email@yahoo.com','2018-06-18'),('000111222','The One Way','8172727457','john.smythe@uta.edu','2018-06-28'),('0011223344','The Serious Series','8172727457','john.smythe@uta.edu','2018-06-28'),('00112244','Skippy','2141234344','skippy@yahoo.com','2018-06-19'),('106334','Selenium366891','1111111111','johnny@email.com','2018-08-02'),('111222333444','Arlington Auto','8172722222','aauto@email.com','2018-06-28'),('111333222444','Arlington Stadium','8172721234','astadium@email.com','2018-06-28'),('111333555777','Texas Rangers','8172727457','john.smythe@uta.edu','2018-06-28'),('11223344','Arlington Coat','8172722154','coat@email.com','2018-06-28'),('1213161895','Fort Worth Omni','8172324890','fwomni@emails.com','2018-06-28'),('12131763','Company Name Here','8172221000','name@yahoo.com','2018-06-28'),('123321','BackwardsForwards','2133451234','reverso@yahoo.com','2018-06-19'),('123454321','Forwards Backwards','8172727457','john.smythe@uta.edu','2018-06-27'),('123456','University of Texas at Arlingt','8172727457','john.smythe@uta.edu','2018-06-18'),('12345600','University of Texas at Arlington','8172727457','john.smythe@uta.edu','2018-06-28'),('123456000','University of Texas at Arlington','8172727457','john.smythe@uta.edu','2018-06-28'),('123456516','Company Name','8172568741','guess@email.com','2018-07-19'),('12345654123','The Macrosoft Way','1234567890','oneway@email.com','2018-07-19'),('12345654321','Christ the King Church','8177321548','theking@email.com','2018-06-28'),('123456654321','Arlington Manufacturing','8172727457','john.smythe@uta.edu','2018-06-28'),('12345665451','My Company','9874561230','mine@email.com','2018-07-25'),('1234567','Dallas Aquarium','2145551616','fish@email.net','2018-06-28'),('123456989','Benbrook Bakery','8172727457','john.smythe@uta.edu','2018-06-29'),('123456999','Mansfield Plumbing','8177771547','mplumb@email.com','2018-06-29'),('129','University of Texas at Arlington','8172727457','john.smythe@uta.edu','2018-06-25'),('131523','Selenium207423','6242561374','898185@email.com','2019-12-28'),('1613168','Benbrook Antique Mall','8172491548','john.smythe@uta.edu','2018-06-28'),('16164587','Benbrook Walmart','8172491812','benwalmart@email.com','2018-06-28'),('169456','Selenium549852','2397377602','238338@email.com','2019-12-28'),('171513','Selenium842167','7567145687','135979@email.com','2019-12-28'),('173371','Selenium297656','4873564162','519437@email.com','2020-01-12'),('187242','Selenium912404','4031164482','301671@email.com','2019-12-28'),('189194','Selenium614228','6501102769','187652@email.com','2019-12-28'),('212313414','Fort Worth Hyatt','8172231847','fwhyatt@email.com','2018-06-28'),('222555666','Fort Worth Hilton','8172221000','fwhilton@email.com','2018-06-28'),('22446688','Test','2141234343','test@yahoo.com','2018-06-19'),('2255887','Stranger Yet','2223334567','yet@yahoo.com','2018-06-19'),('2277443','SlamClub','8172223344','samsclub@yahoo.com','2018-06-19'),('23097429875','Benbrook Trash Co','8172491948','trash@email.com','2018-06-28'),('234209804','Fort Worth Water Gardens','8177321547','fwwater@email.com','2018-06-30'),('23465634','Lake Worth Walgreens','8177362258','lwwalgreens@email.com','2018-06-28'),('234786589','Lake Worth CVS','8177321548','lwcvs@email.com','2018-06-28'),('23949859845','Benbrook City Hall','8172491548','bcityhall@email.com','2018-06-28'),('249966','Selenium629918','3293303412','884720@email.com','2019-12-28'),('250337','Selenium495593','4569648788','466197@email.com','2020-01-12'),('250468','Selenium903952','3088738008','833933@email.com','2020-01-12'),('252525','The Bean','1235678940','beanery@yahoo.com','2018-06-18'),('2535345908','The Tester','4524568495','testy@email.com','2018-06-28'),('258822','Selenium951243','1892257143','989685@email.com','2019-12-28'),('281318','Selenium239614','6072068768','784430@email.com','2019-12-28'),('312312454','Mansfield Gas Co','8177975412','mgc@email.com','2018-06-29'),('31415162','Pie','8172491975','pie@yahoo.com','2018-06-22'),('31614','The Odd Pie Out','8172727457','john.smythe@uta.edu','2018-06-27'),('3216198113','Fort Worth Star','8172945878','star@email.com','2018-06-28'),('332266876','Wibble Wobble','8172490000','wibble@yahoo.com','2018-06-28'),('333135','The Last Straw','8172934356','laststraw@yahoo.com','2018-06-21'),('333246','University of Texas at Arlington','8172491973','whibble@yahoo.com','2018-06-21'),('333311','Unique','1233214444','unique@yahoo.com','2018-06-19'),('3333332','Stranger Yet','0001111234','yet1@yahoo.com','2018-06-19'),('3333339','Goldfinger','8171231234','gold@yahoo.com','2018-06-19'),('333333992','Named Company','9876543212','named@email.com','2018-07-19'),('333334','Unique','8172727457','john.smythe@uta.edu','2018-06-19'),('333399','Strangelove','2013231345','slove@yahoo.com','2018-06-19'),('333444','Big Jake','7772221234','bjake@yahoo.com','2018-06-18'),('3343333992','Named Company','9876543212','named@email.com','2018-07-19'),('3415692','Dallas Emporium','2145551212','emp@email.com','2018-06-28'),('34567890','University of Texas at Arlington','8172727457','john.smythe@uta.edu','2018-06-26'),('349874992','Fort Worth Hoedown','8172495488','hoedown@email.com','2018-06-28'),('3563563','Company','123457896','yahoo@yahoo.com','2018-06-18'),('363','Armstrong','1234321000','armstrong@yahoo.com','2018-06-19'),('363906','Selenium281195','1963847364','578633@email.com','2019-12-28'),('382279','Selenium877175','7773755559','151724@email.com','2019-12-28'),('431965','Selenium249214','2735173478','274519@email.com','2019-12-28'),('433456','Selenium208491','7234222739','562771@email.com','2019-12-28'),('441140','Selenium301972','3672349109','314377@email.com','2019-12-28'),('444444','LastestTest','2145211234','latesttest@yahoo.com','2018-06-19'),('460903','Selenium776601','6492711618','616688@email.com','2019-12-28'),('46516512','Test Case','8172954578','testcase@email.com','2018-07-05'),('5154849546','Lake Worth Walmart','8177321548','lwwalmart@email.com','2018-06-28'),('52521','the Bignew','6821342345','bignew@yahoo.com','2018-06-18'),('54651321984','Benbrook Walgreens','8172491548','benwalgreens@email.com','2018-06-28'),('554994','Selenium224719','7092904658','709157@email.com','2020-01-12'),('555','Five times three','8172727457','john.smythe@uta.edu','2018-06-19'),('555666','Behemoth','1234567890','behemoth@yahoo.com','2018-06-19'),('555777','University of Texas at Arlington','8172982913','first.last@yahoo.com','2018-06-20'),('5566774','The Strangest','8175551234','strange@yahoo.com','2018-06-19'),('582949','Selenium673505','9605685486','869651@email.com','2019-12-28'),('61616264','Benbrook Walmart','8172491000','bwalmart@email.com','2018-06-28'),('651132135','Fort Worth Campus','8174541875','campus@email.com','2018-06-30'),('651180','Selenium360650','1771687064','763621@email.com','2019-12-28'),('654321','Wibble','8171112345','arryn.smythe@yahoo.com','2018-06-18'),('666218','Selenium727322','2962279717','447393@email.com','2019-12-28'),('668384','Selenium137964','2078917142','514104@email.com','2019-12-28'),('681516251','The Pancake House','8172491937','mine@email.com','2018-06-30'),('681651781','Benbrook Fire Department','8172491000','fire@email.com','2018-06-28'),('68496849184','Mansfield Bakery','8172727457','john.smythe@uta.edu','2018-06-29'),('693339','Selenium259543','7445801522','802482@email.com','2019-12-28'),('705404','Selenium307685','3281551177','475329@email.com','2020-01-12'),('746990','Selenium786219','8063037751','356193@email.com','2019-12-28'),('752541','Selenium533578','4604503829','407622@email.com','2019-12-28'),('754197','Selenium121637','7618212591','413718@email.com','2019-12-28'),('756553','Selenium278680','7167428377','451452@email.com','2019-12-28'),('789326','Selenium674247','8448776596','972254@email.com','2019-12-28'),('81813513','The Shining Ones','8172727457','shining@email.com','2018-06-30'),('822743','Selenium451322','2722292139','452479@email.com','2019-12-28'),('888888','whatsamatterU','3334445678','email@yahoo.com','2018-06-18'),('888999','Ur Company','9871234568','ucomp@email.com','2018-07-27'),('89674523','Arlington Rent A Car','8172982913','arryn.smythe@yahoo.com','2018-06-28'),('9292921','Mesquite Rodeo','5142587890','barrel@email.com','2018-06-28'),('934357','Selenium872546','3311028251','969430@email.com','2019-12-28'),('939392','Dallas Bus','2141615859','dbus@email.com','2018-06-28'),('964725','Selenium753491','3027205623','383767@email.com','2019-12-28'),('987698765432','Whataburger','8172727457','john.smythe@uta.edu','2018-06-28'),('989895816','University of Texas at Arlington','8172727457','john.smythe@uta.edu','2018-07-01'),('99225547','Chuck E Cheeses','8172451975','chuckitup@email.com','2018-07-01'),('999','AAAA The First Company','1234567890','mine@yahoo.com','2018-06-18'),('999000111','Baltimore Orioles','2037891547','orioles@email.com','2018-06-28'),('9990001119','University of Texas at Arlington','8172727457','john.smythe@uta.edu','2018-06-29'),('999000222','University of Texas at Arlington','8172727457','john.smythe@uta.edu','2018-06-28'),('99911225','Company Pizza','1524561155','pizza@email.com','2018-07-19'),('9991232213','University of Texas at Arlington','8172727457','john.smythe@uta.edu','2018-07-17'),('999165136','University of Texas at Arlington','8172727457','john.smythe@uta.edu','2018-07-01'),('999213','University of Texas at Arlington','8172982913','name.surname@yahoo.com','2018-06-20'),('9992151648','University of Texas at Arlington','8172727457','john.smythe@uta.edu','2018-06-29'),('999215165','Mansfield Bakery','8172985462','mbakery@email.com','2018-06-29'),('99931316565','University of Texas at Arlington','8172727457','john.smythe@uta.edu','2018-06-29'),('9993261516','University of Texas at Arlington','8172727457','john.smythe@uta.edu','2018-06-29'),('99935169651','University of Texas at Arlington','8172727459','john.smythe@uta.edu','2018-06-29'),('999651651','University of Texas at Arlington','8172727457','john.smythe@uta.edu','2018-07-01'),('999651652','University of Texas at Arlington','8172727457','john.smythe@uta.edu','2018-07-01'),('999777','University of Texas at Arlington','8172727457','john.smythe@uta.edu','2018-06-26'),('999888','Your Company','1232342345','smith@email.com','2018-07-27'),('999888115','Mansfield Pharmacy','8172562547','mpharm@email.com','2018-06-29'),('999999','Big Company','0987654321','bigc@yahoo.com','2018-06-18');
/*!40000 ALTER TABLE `company` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `employee`
--

DROP TABLE IF EXISTS `employee`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `employee` (
  `idemployee` varchar(16) NOT NULL,
  `name` varchar(45) NOT NULL,
  `surname` varchar(45) NOT NULL,
  `badge` varchar(5) NOT NULL,
  `FK_company` varchar(16) NOT NULL,
  `date_ins` date NOT NULL,
  PRIMARY KEY (`idemployee`),
  KEY `FK_company_idx` (`FK_company`),
  CONSTRAINT `FK_company` FOREIGN KEY (`FK_company`) REFERENCES `company` (`idcompany`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `employee`
--

LOCK TABLES `employee` WRITE;
/*!40000 ALTER TABLE `employee` DISABLE KEYS */;
INSERT INTO `employee` VALUES ('009944','John','Smythe','00000','555666','2018-06-19'),('100','Brett','Blamer','12345','555777','2018-06-20'),('10001231','Sam','Shori','1234','212313414','2018-06-28'),('10001232','Sue','Terrific','12346','212313414','2018-06-28'),('1001','John','Smith','100','333399','2018-06-19'),('1002','Jack','Dempsey','12','333399','2018-06-19'),('102127','John','Smythe','12345','999213','2018-06-20'),('102128','Arryn','Smythe','12345','333334','2018-06-19'),('1021294','John','Smythe','10212','2277443','2018-06-19'),('1021296','Arryn','Smythe','33333','999','2018-06-19'),('102129921201','John','Smythe','12345','111222333444','2018-06-28'),('12234','Dummy','James','12334','999','2018-06-19'),('1232156','Object','Oriented','32425','12345654123','2018-07-19'),('12345611','Arryn','Smythe','12345','2277443','2018-06-19'),('12345676','Arryn','Smythe','12345','3333332','2018-06-19'),('12345677','Arryn','Smythe','12345','22446688','2018-06-19'),('12345678','John','Smythe','12345','3563563','2018-06-18'),('12345678923','Marcus','Aurellius','100','23949859845','2018-06-28'),('12345678982','John','Smith','100','234786589','2018-06-28'),('123459876','Mark','Aaron','12345','999000111','2018-06-28'),('123499','James','Queen','33322','333135','2018-06-21'),('127','John','Smythe','00000','999','2018-06-18'),('128','Arryn','Smythe','12345','999','2018-06-18'),('129','James','Elixer','333','999','2018-06-18'),('13132','Jeff','Davis','12546','999651651','2018-07-01'),('132132','John Robb','Smythe','100','9991232213','2018-07-17'),('134255','Sam','Spade','100','23465634','2018-06-28'),('156516','Jeff','Davis','32145','99225547','2018-07-01'),('165136521','Paul','Tarsus','12423','999651652','2018-07-01'),('200','John','Steel','10212','363','2018-06-19'),('201','John','Smythe','10212','333135','2018-06-21'),('202','Arryn','Smythe','00000','333135','2018-06-21'),('21346578','James','Mulligan','12345','111333222444','2018-06-28'),('225577','Arryn','Smythe','12345','3333339','2018-06-19'),('22664','Arryn','Smythe','12345','123321','2018-06-19'),('22664477','Arryn','Smythe','55555','999','2018-06-19'),('22998844','Arryn','Smythe','12345','333311','2018-06-19'),('23409809','Sam','Spade','100','23097429875','2018-06-28'),('286','Maxwell','Smart','10212','52521','2018-06-18'),('299','James','Baker','234','52521','2018-06-18'),('301','Arryn','Smythe','00000','333246','2018-06-21'),('302','John','Smythe','55555','333246','2018-06-21'),('303','James','Queen','33221','333246','2018-06-21'),('31321651','Sarah','Stanley','65165','999','2018-06-30'),('31416625','John','Smythe','12345','123456000','2018-06-28'),('314441','Jack','BeNimble','74058','131523','2019-12-28'),('318774','Jack','BeNimble','85510','250468','2020-01-12'),('33445566','John','Smythe','12345','31415162','2018-06-22'),('3456543','Arryn','Smythe','179','444444','2018-06-19'),('363919','Arryn','Smythe','10212','34567890','2018-06-26'),('400','Arryn','Hammer','179','363','2018-06-19'),('443474','Jack','BeNimble','74157','441140','2019-12-28'),('465930','Jack','BeNimble','41557','964725','2019-12-28'),('49837492894','Westerly','Wear','100','349874992','2018-06-28'),('500','Matt','Markell','1245','363','2018-06-19'),('51625','Sam','Spade','32144','99225547','2018-07-01'),('54321','John','Smythe','12345','34567890','2018-06-26'),('5465116','Rajan','Swarma','32452','888999','2018-07-27'),('56165132','Larry','Brown','12354','651132135','2018-06-30'),('56516513','Jeff','Davis','12345','123456999','2018-06-29'),('5651653','James','Mason','12345','46516512','2018-07-05'),('600','Eileen','Smith','231','363','2018-06-19'),('633122','Jack','BeNimble','30269','187242','2019-12-28'),('6353213','Jake','Strump','12345','234209804','2018-06-30'),('651132','Sam','Spade','12345','312312454','2018-06-29'),('651516221','John','Smith','6513','999','2018-06-30'),('651613232','Steve','Campton','65461','651132135','2018-06-30'),('653213','Jeff','Davis','13546','989895816','2018-07-01'),('6562132','Jeff','Davis','1234','681516251','2018-06-30'),('65621325','Light','Head','65165','999','2018-06-30'),('68146132','Karen','Smith','3225','81813513','2018-06-30'),('682','Johnny','Boy','266','52521','2018-06-18'),('699529','Jack','BeNimble','61950','666218','2019-12-28'),('702512','Jack','BeNimble','23179','554994','2020-01-12'),('747957','Jack','BeNimble','88979','249966','2019-12-28'),('768777','Jack','BeNimble','58124','582949','2019-12-28'),('833478','Jack','BeNimble','86144','754197','2019-12-28'),('908863','Jack','BeNimble','20437','752541','2019-12-28'),('921','Mark','Spitz','134','999','2018-06-18'),('987654','Arryn','Smythe','12345','555','2018-06-19'),('992','John','Smith','12345','52521','2018-06-18'),('993860','Jack','BeNimble','9999','106334','2018-08-02'),('9998','John','Smythe','00000','999','2018-06-19'),('9999','First','Last','00000','3563563','2018-06-18');
/*!40000 ALTER TABLE `employee` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-01-18  9:07:26
