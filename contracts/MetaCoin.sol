// SPDX-License-Identifier: GPL-3.0

pragma solidity >=0.7.0 <0.9.0;
pragma experimental ABIEncoderV2;

contract MetaCoin {

	struct Foo {
		string id;
		string name;
	}

	struct Bar {
		uint id;
		string data;
	}



	function setFoo(Foo memory _toSet) public {
	}


	function setBar(Bar memory _toSet) public {
	}




	event Event(address indexed _address, Foo _foo, Bar _bar);
}