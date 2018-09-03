<?php
class MciApi
{
    public function __construct()
    {
    }

    public function status($mobile)
    {
        $event = __FUNCTION__;
        $data["mobile"] = $mobile;
        $request = $this->sendApiRequest($event, $data);
        switch ($request) {
            case "NOTFOUND":
                return json_encode(["result" => true, "status" => false]);
                break;
            case "ON":
                return json_encode(["result" => true, "status" => true]);
                break;
            case "OFF":
                return json_encode(["result" => true, "status" => false]);
                break;
            default:
                return json_encode(["result"=>false, "ERR"=>$request]);
        }

    }
    public function sub($mobile)
    {
        $event = __FUNCTION__;
        $data["mobile"] = $mobile;

        $resSub = $this->sendApiRequest($event, $data);
        $resExp = explode(".",$resSub);
        if($resExp[0] == "SUCCESS"){
            return json_encode(["result"=>true,"status"=>true , "tid"=>$resExp[1] ]);
        }else if($resExp[0] == "ERROR") {
            return json_encode(["result"=>true,"status"=>false , "message"=>$resExp[1] ]);
        }else{        
            return json_encode(["result"=>false, "ERR"=>$resSub ]);
        }
    }

    public function unsub($mobile)
    {
        $event = __FUNCTION__;
        $data["mobile"] = $mobile;

        $resSub = $this->sendApiRequest($event, $data);
        $resExp = explode(".",$resSub);
        if($resExp[0] == "SUCCESS"){
            return json_encode(["result"=>true,"status"=>true]);
        }else if($resExp[0] == "FAILED"){
            return json_encode(["result"=>true,"status"=>true , "message"=>"FAILED" ]);
        }else if($resExp[0] == "ERROR"){
            return json_encode(["result"=>false,"status"=>false, "message"=>$resExp[1] ]);
        }

    }

    public function check($tid,$pin)
    {
        $event = __FUNCTION__;
        $data["tid"] = $tid;
        $data["pin"] = $pin;

        $resSub = $this->sendApiRequest($event, $data);
        $resExp = explode(".",$resSub);
        if($resExp[0] == "SUCCESS"){
            return json_encode(["result"=>true,"status"=>true]);
        }else if($resExp[0] == "FAILED"){
            return json_encode(["result"=>true,"status"=>false , "message"=>"FAILED" ]);
        }else if($resExp[0] == "ERROR"){
            return json_encode(["result"=>false,"status"=>false, "message"=>$resExp[1] ]);
        }else{
            return json_encode(["result"=>false,"status"=>false, "message"=>$resSub ]);
        }

    }


    public function sendApiRequest($event, $data)
    {
        $head = array("Authorization: key=dc8c8671-ab4f-11e8-8129-00505696ce21");
        $data["sid"] = "39d34a36-ab50-11e8-8129-00505696ce21";
        $url = "http://vas.rpg.ir/api/member/" . $event;
        $ch = curl_init($url);
        curl_setopt($ch, CURLOPT_POSTFIELDS, $data);
        curl_setopt($ch, CURLOPT_HTTPHEADER, $head);
        curl_setopt($ch, CURLOPT_RETURNTRANSFER, 1);
        $res = curl_exec($ch);
        curl_close($ch);
        return $res;
    }

}


/*
$mci_api = new MciApi();

echo $mci_api->status("09151000960");
echo "\n";
sleep(10);
echo $mci_api->sub("09151000960");
echo "\n";
sleep(10);
echo $mci_api->unsub("09151000960");
echo "\n";
sleep(10);
echo $mci_api->check("1231234","1231");
echo "\n";
*/