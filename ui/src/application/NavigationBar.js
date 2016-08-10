import React from "react";
import Reflux from "reflux";

import {Navbar} from "react-bootstrap";

import InventoryStore from "../inventory/InventoryStore.js";


export default React.createClass({
	mixins: [Reflux.connect(InventoryStore, "inventory")],

	render() {
		let info = null;
		let inventory = this.state.inventory;
		if (inventory) {
			info = <span> - {inventory.mainClass} <span className="text-muted">({inventory.userName}@{inventory.hostName})</span></span>;
		}
		return <Navbar fixedTop={true} fluid={true} >
			<Navbar.Header>
				<Navbar.Brand>
					<a href="#">jimix</a>
				</Navbar.Brand>
			</Navbar.Header>
			{info}
		</Navbar>;
	}
})
