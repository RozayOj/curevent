import React from 'react';
import Footer from "../components/Footer";
import '../css/PorfilePage.css';
import TimeLine from "../components/TimeLine";
import Profile from "../components/Profile";
import Header from "../components/Header";

function ProfilePage() {
    return (
        <div className="profile-page">
            <Header/>
            <div className="profile-container">
                <Profile/>
                <TimeLine/>
            </div>
        </div>
    );
}

export default ProfilePage;